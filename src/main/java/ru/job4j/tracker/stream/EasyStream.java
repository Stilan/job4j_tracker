package ru.job4j.tracker.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EasyStream {

    List<Integer> integerList = new ArrayList<>();

    public void setIntegerList(List<Integer> integerList) {
        this.integerList = integerList;
    }

    public List<Integer> getIntegerList() {
        return integerList;
    }

    public static EasyStream of(List<Integer> source) {
        EasyStream easyStream = new EasyStream();
        easyStream.setIntegerList(source.stream().collect(Collectors.toUnmodifiableList()));
       return easyStream;
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        EasyStream easyStream = new EasyStream();
        List<Integer> integerList2 = new ArrayList<>();
        for (int i = 0; i < integerList.size(); i++) {
          integerList2.add(fun.apply(integerList.get(i)));
        }
        easyStream.setIntegerList(integerList2);
        return easyStream;
    }

    public EasyStream filter(Predicate<Integer> fun) {
        EasyStream easyStream = new EasyStream();
        List<Integer> integerList2 = new ArrayList<>();
        for (int i = 0; i < integerList.size(); i++) {
            if (fun.test(integerList.get(i))) {
                integerList2.add(integerList.get(i));
            }
        }

        easyStream.setIntegerList(integerList2);
        return easyStream;
    }

    public List<Integer> collect() {
        return integerList;
    }
}
