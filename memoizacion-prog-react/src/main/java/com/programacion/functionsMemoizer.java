package com.programacion;

import java.util.HashMap;
import java.util.Map;

public class functionsMemoizer {
    private static final Map<String, Integer> cache = new HashMap<>();

    public static int memoizedAdd(int a, int b) {
        String key = a + "," + b;

        if (cache.containsKey(key)) {
            System.out.println("Usando caché para " + key);
            return cache.get(key);
        }

        int result = a + b;
        cache.put(key, result);
        return result;
    }

}
