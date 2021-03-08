package ru.job4j.tracker.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EasyStream {
    private List<Integer> integerList = new ArrayList<>();

    private EasyStream(List<Integer> integerList) {
        this.integerList = integerList;
    }

    public static EasyStream of(List<Integer> source) {
       return new EasyStream(source.stream().collect(Collectors.toUnmodifiableList()));
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        List<Integer> integerList2 = new ArrayList<>();
        for (int i = 0; i < integerList.size(); i++) {
          integerList2.add(fun.apply(integerList.get(i)));
        }
        return new EasyStream(integerList2.stream().collect(Collectors.toUnmodifiableList()));
    }

    public EasyStream filter(Predicate<Integer> fun) {
        List<Integer> integerList2 = new ArrayList<>();
        for (int i = 0; i < integerList.size(); i++) {
            if (fun.test(integerList.get(i))) {
                integerList2.add(integerList.get(i));
            }
        }
        return new EasyStream(integerList2.stream().collect(Collectors.toUnmodifiableList()));
    }

    public List<Integer> collect() {
        return integerList;
    }
}
