package org.jfinance.stock.service;

import org.jfinance.stock.model.FinancialData;
import org.jfinance.stock.model.Stock;
import org.jfinance.utils.DataScrapper;
import org.jfinance.utils.RequestSender;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;

public class StockService {
    private static final String OPTIONS_URL = "https://query1.finance.yahoo.com/v6/finance/options/";
    private static final String SEARCH_URL = "https://query1.finance.yahoo.com/v1/finance/search?q=";

    public static Stock getStock(String symbol) throws IOException, InterruptedException {

        HttpRequest optionsRequest = HttpRequest.newBuilder()
                .uri(URI.create(OPTIONS_URL + symbol))
                .build();

        HttpRequest searchRequest = HttpRequest.newBuilder()
                .uri(URI.create(SEARCH_URL + symbol))
                .build();

        Stock stock = RequestSender.sendStockRequest(optionsRequest, searchRequest);
        FinancialData financialData = stock.getFinancialData();

        String name = stock.getName();

        stock.setSummary(DataScrapper.getSummary(symbol));
        financialData.setEbitda(DataScrapper.getEbitda(symbol, name));
        financialData.setTotalLiabilities(DataScrapper.getTotalLiabilities(symbol, name));
        financialData.setCashOnHands(DataScrapper.getCashOnHands(symbol, name));

        return stock;
    }
}
