package org.jfinance.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class DataScrapper {
    private static final int MAX_RETRIES = 5;
    private static final int DELAY_BETWEEN_REQUESTS = 2000; // 2000 ms = 2 seconds

    /**
     * Retrieves a brief summary for a given stock symbol from TradingView.
     *
     * @param symbol The stock symbol to get the summary for.
     * @return The summary of the stock.
     * @throws IOException If an I/O error occurs during the connection.
     */
    public static String getSummary(String symbol) throws IOException {
        String url = "https://www.tradingview.com/symbols/" + symbol;
        Document doc = Jsoup.connect(url).get();
        Elements elements = doc.select("div.content-OkHxJmnJ span");
        Element element = elements.first();
        String summary = element.text();
        return summary;
    }

    /**
     * Retrieves the EBITDA (Earnings Before Interest, Taxes, Depreciation, and Amortization) for a given stock symbol from MacroTrends.
     *
     * @param symbol The stock symbol to get the EBITDA for.
     * @param name The name of the company.
     * @return The EBITDA value.
     * @throws IOException If an I/O error occurs during the connection.
     */
    public static String getEbitda(String symbol, String name) throws IOException {
        String url = buildMTUrl(symbol, name) + "ebitda";
        return getDataFromMT(url);
    }

    /**
     * Retrieves the cash on hand for a given stock symbol from MacroTrends.
     *
     * @param symbol The stock symbol to get the cash on hand for.
     * @param name The name of the company.
     * @return The cash on hand value.
     * @throws IOException If an I/O error occurs during the connection.
     */
    public static String getCashOnHands(String symbol, String name) throws IOException {
        String url = buildMTUrl(symbol, name) + "cash-on-hand";
        return getDataFromMT(url);
    }

    /**
     * Retrieves the total liabilities for a given stock symbol from MacroTrends.
     *
     * @param symbol The stock symbol to get the total liabilities for.
     * @param name The name of the company.
     * @return The total liabilities value.
     * @throws IOException If an I/O error occurs during the connection.
     */
    public static String getTotalLiabilities(String symbol, String name) throws IOException {
        String url = buildMTUrl(symbol, name) + "total-liabilities";
        return getDataFromMT(url);
    }

    /**
     * Constructs the URL for the MacroTrends page of a given stock symbol and company name.
     *
     * @param symbol The stock symbol.
     * @param name The name of the company.
     * @return The constructed URL.
     */
    private static String buildMTUrl(String symbol, String name) {
        String formattedName = name.split(" ")[0];
        return  "https://www.macrotrends.net/stocks/charts/" + symbol + "/" + formattedName + "/";
    }

    /**
     * Retrieves data from MacroTrends for a given URL.
     *
     * @param url The URL to retrieve data from.
     * @return The data extracted from the page.
     * @throws IOException If an I/O error occurs during the connection.
     */
    private static String getDataFromMT(String url) throws IOException {
        Document doc = connectWithRetry(url);
        Element firstElement = doc.select("div > span > ul > li").first();
        if (firstElement != null) {
            Element strongElement = firstElement.select("strong").first();
            if (strongElement != null) {
                return strongElement.text();
            } else {
                return "Data not found";
            }
        } else {
            return "Data not found";
        }
    }

    /**
     * Attempts to connect to a given URL with retries in case of a 429 (Too Many Requests) status code.
     *
     * @param url The URL to connect to.
     * @return The Document object representing the page.
     * @throws IOException If an I/O error occurs during the connection.
     */
    private static Document connectWithRetry(String url) throws IOException {
        int retries = 0;
        while (retries < MAX_RETRIES) {
            try {
                Document doc = Jsoup.connect(url)
                        .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36")
                        .timeout(50000)
                        .get();
                return doc;
            } catch (IOException e) {
                if (e.getMessage().contains("Status=429")) {
                    System.out.println("Received 429 status code. Retrying after delay...");
                    try {
                        Thread.sleep(DELAY_BETWEEN_REQUESTS);
                    } catch (InterruptedException ie) {
                        Thread.currentThread().interrupt();
                        throw new IOException("Interrupted during delay between requests", ie);
                    }
                    retries++;
                } else {
                    throw e;
                }
            }
        }
        throw new IOException("Failed to connect to " + url + " after " + MAX_RETRIES + " retries");
    }
}
