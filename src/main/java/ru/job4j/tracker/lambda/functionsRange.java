package ru.job4j.tracker.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class functionsRange {
    public static List<Double> diapason(int start, int end, Function<Double, Double> func) {
         List<Double> res = new ArrayList<>();

        for (int i = start; i < end; i++) {
            res.add(func.apply((double) i));
        }
         return res;
    }
}
