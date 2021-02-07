package ru.job4j.tracker.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ArrayListInteger {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
          int ranInteger = random.nextInt(11) - (1);
          list.add(ranInteger);
        }
        System.out.println(list);
        list = list.stream().filter(
                Integer -> Integer > 0
                ).collect(Collectors.toList());
        System.out.println(list);
    }
}
