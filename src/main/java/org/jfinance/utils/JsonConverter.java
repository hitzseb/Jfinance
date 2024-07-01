package org.jfinance.utils;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.ArrayList;
import java.util.List;

public class JsonConverter {
    public static List<Double> convertJsonNodeToList(JsonNode node) {
        List<Double> list = new ArrayList<>();
        for (JsonNode n : node) {
            list.add(n.asDouble());
        }
        return list;
    }

    public static List<Long> convertJsonNodeToListLong(JsonNode node) {
        List<Long> list = new ArrayList<>();
        for (JsonNode n : node) {
            list.add(n.asLong());
        }
        return list;
    }
}
