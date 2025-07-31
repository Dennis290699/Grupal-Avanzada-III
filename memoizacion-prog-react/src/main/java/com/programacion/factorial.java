package com.programacion;

import java.util.HashMap;
import java.util.Map;

public class factorial {
    private static final Map<Integer, Long> cache = new HashMap<>();

    public static long fact(int n) {
        if (n == 0 || n == 1)
            return 1;

        if (cache.containsKey(n)) {
            System.out.println("Usando caché para " + n);
            return cache.get(n);
        }

        long result = n * fact(n - 1);
        cache.put(n, result);
        return result;
    }

}
