package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *  @version 0.0.0.1
 *  @since 2019.02.24
 *  @author Chashkov Alexander
 *  класс школа
 */
public class School {
    public List<Student> collect(List<Student> students, Predicate<Student> predict) {
        return students.stream().filter(predict).collect(Collectors.toList());
    }

    public Map<String, Student> collectToMap(List<Student> students) {
        return students.stream().collect(Collectors.toMap(st -> st.getSurname(), st -> st));
    }
}
