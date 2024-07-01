package org.jfinance.chart.service;

import org.jfinance.chart.model.Chart;
import org.jfinance.utils.RequestSender;
import org.jfinance.utils.TimestampConverter;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.util.Arrays;
import java.util.List;

public class ChartService {
    /*
    Valid interval values from 1 minute to 3 months:
    1m, 2m, 5m, 15m, 30m, 60m, 90m, 1h, 1d, 5d, 1wk, 1mo, 3mo
     */
    private static final List<String> VALID_INTERVALS = Arrays.asList("1d", "5d", "1mo", "3mo", "6mo", "1y", "2y", "5y", "10y", "ytd", "max");

    /*
    Valid range values from 1 day to 10 years, year to date or first trade date (max):
    1d, 5d, 1mo, 3mo, 6mo, 1y, 2y, 5y, 10y, ytd, max
     */
    private static final List<String> VALID_RANGES = Arrays.asList("1d", "5d", "1mo", "3mo", "6mo", "1y", "2y", "5y", "10y", "ytd", "max");

    // Base URL for HTTP request
    private static final String BASE_URL = "https://query1.finance.yahoo.com/v8/finance/chart/";


    public static Chart getChart(String symbol, String interval, String range) throws IOException, InterruptedException {
        if (interval == null || interval.isEmpty() || !VALID_INTERVALS.contains(interval)) {
            interval = "1d";  // default interval value
        }
        if (range == null || range.isEmpty() || !VALID_RANGES.contains(range)) {
            range = "5d";  // default range value
        }

        HttpRequest request = buildRequest(symbol, interval, range);

        return RequestSender.sendChartRequest(request);
    }

    public static Chart getChart(String symbol, String interval, String period1, String period2) throws IOException, InterruptedException {
        if (interval == null || interval.isEmpty() || !VALID_INTERVALS.contains(interval)) {
            interval = "1d";  // default interval value
        }

        long period1Timestamp = TimestampConverter.convertDateToTimestamp(period1, "America/New_York");
        long period2Timestamp = TimestampConverter.convertDateToTimestamp(period2, "America/New_York");

        HttpRequest request = buildRequest(symbol, interval, period1Timestamp, period2Timestamp);

        return RequestSender.sendChartRequest(request);
    }

    private static HttpRequest buildRequest(String symbol, String interval, String range) {
        return HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + symbol + "?interval=" + interval + "&range=" + range))
                .build();
    }

    private static HttpRequest buildRequest(String symbol, String interval, long period1, long period2) {
        return HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + symbol + "?interval=" + interval + "&period1=" + period1 + "&period2=" + period2))
                .build();
    }
}
