package ru.job4j.tracker.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {
    public static double averageScore(Stream<Pupil> stream) {
        return stream.flatMap(pupil -> pupil.getSubjects().stream())
                .mapToInt(Subject::getScore)
                .average()
                .orElse(0);
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream.map(Pupil -> (new Tuple(Pupil.getName(), Pupil.getSubjects().stream()
                        .mapToInt(Subject::getScore)
                        .average().orElse(0)))).collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {

        return stream.flatMap(pupil -> pupil.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName,
                        LinkedHashMap::new, Collectors.averagingDouble(Subject::getScore)))
                .entrySet().stream()
                .map(s -> new Tuple(s.getKey(), s.getValue()))
                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream.map(Pupil -> (new Tuple(Pupil.getName(), Pupil.getSubjects().stream()
                .mapToInt(Subject::getScore)
                .sum()))).max(Comparator.comparing(Tuple::getScore)).orElse(null);
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream.flatMap(pupil -> pupil.getSubjects().stream())
                .collect(Collectors
                        .groupingBy(Subject::getName, Collectors.summingDouble(Subject::getScore)))
                .entrySet().stream()
                .map(stringDoubleEntry -> new Tuple(stringDoubleEntry
                        .getKey(), stringDoubleEntry
                        .getValue()))
                .max(Comparator.comparing(Tuple::getScore)).orElse(null);
    }
}
