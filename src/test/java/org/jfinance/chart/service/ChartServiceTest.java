package org.jfinance.chart.service;

import org.jfinance.chart.model.Chart;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ChartServiceTest {
    @Test
    void testGetChartWithRange() throws IOException, InterruptedException {
        String symbol = "AAPL";
        String interval = "1d";
        String range = "5d";

        Chart chart = ChartService.getChart(symbol, interval, range);

        assertChartItems(chart);
    }

    @Test
    void testGetChartWithPeriod() throws IOException, InterruptedException {
        String symbol = "AAPL";
        String interval = "1d";
        String period1 = "2024-01-01";
        String period2 = "2024-06-30";

        Chart chart = ChartService.getChart(symbol, interval, period1, period2);

        assertChartItems(chart);
    }

    private static void assertChartItems(Chart chart) {
        // Asserts that chart is not null and has valid meta, timestamps and indicators
        assertNotNull(chart);
        assertNotNull(chart.getMeta());
        assertNotNull(chart.getTimestamp());
        assertNotNull(chart.getIndicators());

        // Asserts that timestamps and indicators are not empty
        assertFalse(chart.getTimestamp().isEmpty());
        assertFalse(chart.getIndicators().getQuote().isEmpty());
        assertFalse(chart.getIndicators().getAdjclose().isEmpty());

        // Asserts that some meta elements values are what we expect
        assertEquals("AAPL", chart.getMeta().getSymbol());
        assertEquals("America/New_York", chart.getMeta().getExchangeTimezoneName());

        // Asserts that prices and volumes have valid values
        assertTrue(chart.getMeta().getRegularMarketPrice() > 0);
        assertTrue(chart.getMeta().getRegularMarketVolume() > 0);
    }
}