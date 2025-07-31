package com.programacion;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class GenericMemoizacion {
    public static <T, R> Function<T, R> memoize(Function<T, R> function) {
        Map<T, R> cache = new HashMap<>();
        return input -> cache.computeIfAbsent(input, function);
    }
}
