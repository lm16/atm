package com.controller.config;

import java.util.HashMap;
import java.util.Map;

public class MemoryData {
    private static Map<String, String> sessionIdMap = new HashMap<>();

    public static Map<String, String> getSessionIdMap() {
        return sessionIdMap;
    }

    public static void setSessionIdMap(Map<String, String> sessionIdMap) {
        MemoryData.sessionIdMap = sessionIdMap;
    }
}
