package ru.job4j.tracker.lambda;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class F1 {
    public static void main(String[] args) {
        String[] atts = {
                "А",
                "BBB",
                "VV"
        };
        Comparator<String> comparator = (left, right) -> {
            System.out.println("compare - " + right.length() + " : " + left.length());
            return right.length()  - left.length();
        };
        Arrays.sort(atts, comparator);
        for (String str : atts) {
            System.out.println(str);
        }
    }

}
