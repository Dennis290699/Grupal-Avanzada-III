package com.programacion;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class App {
    public static void main(String[] args) throws Exception {
        // fibonaci
        System.out.println();
        System.out.println("Memoizacion para fibonaci: ");
        fibonaci nf = new fibonaci();
        Function<Integer, Integer> fib = nf::fib;
        System.out.println("fibonaci 10: " + fib.apply(10));
        System.out.println("fibonaci 20: " + fib.apply(20));
        System.out.println("fibonaci 30: " + fib.apply(30));
        ///
        /// Factorizacion
        System.out.println("Memoizacion para factorial: ");
        System.out.println(factorial.fact(5)); // 120 (calcula)
        System.out.println(factorial.fact(6)); // 720 (usa 5! de caché y calcula 6*120)
        System.out.println(factorial.fact(5)); // 120 (usa caché)
        ///
        /// Memoización para funciones de múltiples parámetros
        System.out.println("Memoizacion para funciones de multiples parametros: ");
        System.out.println(functionsMemoizer.memoizedAdd(2, 3)); // 5 (calcula)
        System.out.println(functionsMemoizer.memoizedAdd(3, 2)); // 5 (calcula - clave diferente)
        System.out.println(functionsMemoizer.memoizedAdd(2, 3)); // 5 (usa caché)
        /// Cálculo de Números Primos
        System.out.println("Calculo de numeros primos");
        System.out.println("¿17 es primo? " + numeroPrimo.isPrimeMemoized.test(17)); // Calcula
        System.out.println("¿17 es primo? " + numeroPrimo.isPrimeMemoized.test(17)); // Usa caché
        System.out.println("¿1000000007 es primo? " + numeroPrimo.isPrimeMemoized.test(1_000_000_007)); // Cálculo
                                                                                                        // costoso
        System.out.println("¿1000000007 es primo? " + numeroPrimo.isPrimeMemoized.test(1_000_000_007)); // Respuesta
                                                                                                        // instantánea
                                                                                                        // // desde
                                                                                                        // caché
        // Verificación en un rango (aprovechando la memoización)
        System.out.println("Primos entre 50 y 70:");
        for (int i = 50; i <= 70; i++) {
            if (numeroPrimo.isPrimeMemoized.test(i)) {
                System.out.println(i + ": es numero primo");
            }
        }
        ///
        /// Memoización Genérica con Function
        System.out.println("Memoización Genérica con Function:");
        Function<Double, Double> sinMemo = GenericMemoizacion.memoize(Math::sin);
        System.out.println(sinMemo.apply(30.0)); // Primera vez calcula
        System.out.println(sinMemo.apply(30.0)); // Luego usa caché
        ///
        /// Memoización en Streams
        System.out.println("Memoizacion en Streams: ");
        List<String> names = Arrays.asList("Alice", "Bob", "Alice");
        Function<String, String> process = GenericMemoizacion.memoize(name -> {
            System.out.println("Procesando: " + name);
            return name.toUpperCase();
        });
        names.stream().map(process).forEach(System.out::println);
    }

}
