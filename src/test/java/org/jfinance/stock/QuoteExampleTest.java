package org.jfinance.stock;

import org.jfinance.stock.model.Stock;
import org.jfinance.stock.service.StockService;

import java.io.IOException;
import java.text.ParseException;

public class QuoteExampleTest {
    public static void main(String[] args) throws IOException, InterruptedException, ParseException {
        Stock stock = StockService.getStock("AAPL");
        System.out.println(stock.toString());
    }
}
