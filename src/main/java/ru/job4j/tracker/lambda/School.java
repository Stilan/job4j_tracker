package ru.job4j.tracker.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
public class School {
    public List<Student> collect(List<Student> students, Predicate<Student> predict) {
        List<Student> colStudents = students.stream()
                .filter(predict)
                .collect(Collectors.toList());
        return colStudents;
    }
}
