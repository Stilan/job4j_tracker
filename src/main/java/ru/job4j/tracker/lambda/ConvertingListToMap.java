package ru.job4j.tracker.lambda;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConvertingListToMap {

    public Map<String, Student> isListToMap(List<Student> students) {
        return students.stream().distinct().collect(Collectors.toMap(Student::getSurname,
                student -> student));
    }
}
