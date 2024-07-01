package org.jfinance.stock.mapper;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jfinance.stock.model.FinancialData;
import org.jfinance.stock.model.Stock;
import org.jfinance.utils.NumberFormatter;

import java.io.IOException;

public class StockMapper {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static Stock buildStockfromJson(String optionsJsonStr, String searchJsonStr) throws IOException {
        JsonNode optionsRootNode = objectMapper.readTree(optionsJsonStr);
        JsonNode options = optionsRootNode.at("/optionChain/result/0/quote");

        JsonNode searchRootNode = objectMapper.readTree(searchJsonStr);
        JsonNode search = searchRootNode.at("/quotes/0");

        Stock stock = new Stock();
        FinancialData financialData = new FinancialData();

        stock.setSymbol(options.get("symbol").asText());
        stock.setName(options.get("longName").asText());
        stock.setType(options.get("quoteType").asText());
        stock.setSector(search.get("sector").asText());
        stock.setIndustry(search.get("industry").asText());
        stock.setExchange(search.get("exchDisp").asText());

        // Mapping FinancialData
        financialData.setRegularMarketPrice(
                NumberFormatter.formatNumber(
                options.get("regularMarketPrice").asDouble()
                )
        );
        financialData.setTrailingAnnualDividendYield(
                NumberFormatter.formatNumber(
                        options.get("trailingAnnualDividendYield").asDouble()
                )
        );
        financialData.setTrailingPE(
                NumberFormatter.formatNumber(
                        options.get("trailingPE").asDouble()
                )
        );
        financialData.setMarketCap(
                NumberFormatter.formatNumber(
                        options.get("marketCap").asLong()
                )
        );
        financialData.setBookValue(
                NumberFormatter.formatNumber(
                        options.get("bookValue").asDouble()
                )
        );

        stock.setFinancialData(financialData);

        return stock;
    }
}
