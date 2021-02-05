package ru.job4j.tracker.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class SearchAtt {
    public static List<Attachment> filterSize(List<Attachment> list) {
        Predicate<Attachment> predicate = new Predicate<Attachment>() {
            @Override
            public boolean test(Attachment attachment) {
                return attachment.getSize() > 100;
            }

        };
        Supplier<ArrayList<Attachment>> sup = new Supplier<ArrayList<Attachment>>() {
            @Override
            public ArrayList<Attachment> get() {
                return new ArrayList<>();
            }
        };
        return filter(list, predicate, sup);
    }

    public static List<Attachment> filterName(List<Attachment> list) {
        Predicate<Attachment> predicate = new Predicate<Attachment>() {

            @Override
            public boolean test(Attachment attachment) {
                return attachment.getName().contains("bug");
            }

        };
        Supplier<ArrayList<Attachment>> sup = new Supplier<ArrayList<Attachment>>() {
            @Override
            public ArrayList<Attachment> get() {
                return new ArrayList<>();
            }
        };
        return filter(list, predicate, sup);
    }

    public static List<Attachment> filter(List<Attachment> list, Predicate<Attachment> pred,
                                          Supplier<ArrayList<Attachment>> sup) {
        List<Attachment> rsl = sup.get();
        for (Attachment attachment : list) {
            if (pred.test(attachment)) {
                rsl.add(attachment);
            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        List<Attachment> attachments = Arrays.asList(
                new Attachment("image 1", 101),
                new Attachment("image 2  bug", 34),
                new Attachment("image 3", 13)
        );
        System.out.println(filterName(attachments));
        System.out.println(filterSize(attachments));
    }
}
