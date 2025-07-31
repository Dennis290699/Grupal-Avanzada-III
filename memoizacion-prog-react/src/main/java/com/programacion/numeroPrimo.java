package com.programacion;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class numeroPrimo {
    private static final Map<Integer, Boolean> primeCache = new HashMap<>();

    public static Predicate<Integer> isPrimeMemoized = n -> {
        if (primeCache.containsKey(n)) {
            System.out.println("Usando caché para: " + n);
            return primeCache.get(n);
        }

        boolean result = isPrime(n);
        primeCache.put(n, result);
        return result;
    };

    private static boolean isPrime(int number) {
        System.out.println("Calculando primalidad para: " + number);
        if (number <= 1)
            return false;
        if (number == 2)
            return true;
        if (number % 2 == 0)
            return false;

        for (int i = 3; i * i <= number; i += 2) {
            if (number % i == 0)
                return false;
        }
        return true;
    }
}
