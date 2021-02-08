package ru.job4j.tracker.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Converting {

    public static List<Integer> matricesToList(Integer[][] integers) {
        return Stream.of(integers).flatMap(e -> Arrays.stream(e.clone()))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Integer[][] integers = new Integer[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
              Random random = new Random();
                Integer integer = random.nextInt(10) - 1;
                integers[i][j] = integer;
            }
        }
        List<Integer> integerList = matricesToList(integers);
        System.out.println(integerList);

    }

}
