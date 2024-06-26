package org.jfinance.chart.mapper;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jfinance.chart.model.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ChartMapper {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static Chart fromJson(String jsonStr) throws IOException {
        JsonNode rootNode = objectMapper.readTree(jsonStr);
        JsonNode resultNode = rootNode.at("/chart/result/0");

        // Mapping meta
        JsonNode metaNode = resultNode.at("/meta");
        Meta meta = new Meta();
        meta.setCurrency(metaNode.get("currency").asText());
        meta.setSymbol(metaNode.get("symbol").asText());
        meta.setExchangeName(metaNode.get("exchangeName").asText());
        meta.setFullExchangeName(metaNode.get("fullExchangeName").asText());
        meta.setInstrumentType(metaNode.get("instrumentType").asText());
        meta.setTimezone(metaNode.get("timezone").asText());
        meta.setExchangeTimezoneName(metaNode.get("exchangeTimezoneName").asText());
        meta.setRegularMarketPrice(metaNode.get("regularMarketPrice").asDouble());
        meta.setFiftyTwoWeekHigh(metaNode.get("fiftyTwoWeekHigh").asDouble());
        meta.setFiftyTwoWeekLow(metaNode.get("fiftyTwoWeekLow").asDouble());
        meta.setRegularMarketDayHigh(metaNode.get("regularMarketDayHigh").asDouble());
        meta.setRegularMarketDayLow(metaNode.get("regularMarketDayLow").asDouble());
        meta.setRegularMarketVolume(metaNode.get("regularMarketVolume").asLong());

        // Mapping timestamp
        JsonNode timestampNode = resultNode.at("/timestamp");
        List<Long> timestampList = new ArrayList<>();
        for (JsonNode node : timestampNode) {
            timestampList.add(node.asLong());
        }

        // Mapping indicators
        JsonNode indicatorsNode = resultNode.at("/indicators");
        Indicators indicators = new Indicators();

        // Mapping quote
        List<Quote> quotes = new ArrayList<>();
        JsonNode quoteNode = indicatorsNode.at("/quote/0");
        Quote quote = new Quote();
        quote.setHigh(convertJsonNodeToList(quoteNode.get("high")));
        quote.setClose(convertJsonNodeToList(quoteNode.get("close")));
        quote.setVolume(convertJsonNodeToListLong(quoteNode.get("volume")));
        quote.setOpen(convertJsonNodeToList(quoteNode.get("open")));
        quote.setLow(convertJsonNodeToList(quoteNode.get("low")));
        quotes.add(quote);
        indicators.setQuote(quotes);

        // Mapping adjclose
        List<AdjClose> adjCloses = new ArrayList<>();
        JsonNode adjCloseNode = indicatorsNode.at("/adjclose/0");
        AdjClose adjClose = new AdjClose();
        adjClose.setAdjclose(convertJsonNodeToList(adjCloseNode.get("adjclose")));
        adjCloses.add(adjClose);
        indicators.setAdjclose(adjCloses);

        // Building Chart
        Chart chart = new Chart(meta, timestampList, indicators);
        return chart;
    }

    private static List<Double> convertJsonNodeToList(JsonNode node) {
        List<Double> list = new ArrayList<>();
        for (JsonNode n : node) {
            list.add(n.asDouble());
        }
        return list;
    }

    private static List<Long> convertJsonNodeToListLong(JsonNode node) {
        List<Long> list = new ArrayList<>();
        for (JsonNode n : node) {
            list.add(n.asLong());
        }
        return list;
    }
}
