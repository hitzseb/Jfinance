package org.jfinance.chart.utils;

import java.util.List;

public class TablePrinter {
    //Method for printing a table with Chart data
    public static void printTable(List<Long> timestamps, List<Double> opens, List<Double> highs, List<Double> lows, List<Double> closes, List<Double> adjCloses, List<Long> volumes, String timeZone) {
        // Print the tale heading
        System.out.printf("%-20s %-10s %-10s %-10s %-10s %-10s %-10s\n", "Date", "Open", "High", "Low", "Close", "Adj Close", "Volume");
        System.out.println("--------------------------------------------------------------------------------------");

        // Print the table rows
        for (int i = 0; i < timestamps.size(); i++) {
            String dateStr = TimestampConverter.convertTimestampToDate(timestamps.get(i), timeZone);
            System.out.printf("%-20s %-10.2f %-10.2f %-10.2f %-10.2f %-10.2f %-10d\n",
                    dateStr, opens.get(i), highs.get(i), lows.get(i), closes.get(i), adjCloses.get(i), volumes.get(i));
        }
    }
}
