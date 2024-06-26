package org.jfinance.chart;

import org.jfinance.chart.model.Chart;
import org.jfinance.chart.service.ChartService;

import java.io.IOException;

public class ChartExampleTest {
    public static void main(String[] args) throws IOException, InterruptedException {
        Chart rangeChart = ChartService.getChart("AAPL", "1d", "5d");
        Chart periodChart = ChartService.getChart("AAPL", "1d", "2024-03-01", "2024-04-01");

        System.out.println("\n" + rangeChart.getMeta().toString() + "\n");
        System.out.println("NY timezone" + "\n");
        rangeChart.printTable();

        System.out.println("\n--------------------------------------------------------------------------------------");

        System.out.println("\n" + periodChart.getMeta().toString() + "\n");
        System.out.println("BS timezone" + "\n");
        periodChart.printTable("America/Argentina/Buenos_Aires");
    }
}
