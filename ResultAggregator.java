package com.securityscanner.scanner;

import java.util.HashMap;
import java.util.Map;

public class ResultAggregator {

    private static final Map<String, Integer> results = new HashMap<>();

    public static void addResult(String type, int count) {
        results.put(type, results.getOrDefault(type, 0) + count);
    }

    public static Map<String, Integer> getResults() {
        return results;
    }

    public static void reset() {
        results.clear();
    }
}
