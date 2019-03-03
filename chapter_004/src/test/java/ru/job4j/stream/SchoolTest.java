package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 *  @version 0.0.0.1
 *  @since 2019.02.24
 *  @author Chashkov Alexander
 *  класс тестов для задачи фильтрация учеников
 */
public class SchoolTest {
    /**
     * тест для класса А
     */
    @Test
    public void whenFilterStudentsA() {
        School school =  new School();
        List<Student> ls = new ArrayList<>();
        ls.add(new Student(50));
        ls.add(new Student(20));
        ls.add(new Student(90));
        ls.add(new Student(10));
        ls.add(new Student(80));
        List<Student> res = school.collect(ls, st ->  {
            return st.getScore() >= 70 & st.getScore() <= 100;
        });
        List<Student> expected = new ArrayList<>();
        expected.add(new Student(90));
        expected.add(new Student(80));
        assertTrue(res.toString().equals(expected.toString()));
    }

    /**
     * тест для класса Б
     */
    @Test
    public void whenFilterStudentsB() {
        School school =  new School();
        List<Student> ls = new ArrayList<>();
        ls.add(new Student(50));
        ls.add(new Student(20));
        ls.add(new Student(90));
        ls.add(new Student(10));
        ls.add(new Student(80));
        List<Student> res = school.collect(ls, st ->  {
            return st.getScore() >= 50 & st.getScore() < 70;
        });
        List<Student> expected = new ArrayList<>();
        expected.add(new Student(50));
        assertTrue(res.toString().equals(expected.toString()));
    }

    /**
     * тест для класса В
     */
    @Test
    public void whenFilterStudentsV() {
        School school =  new School();
        List<Student> ls = new ArrayList<>();
        ls.add(new Student(50));
        ls.add(new Student(20));
        ls.add(new Student(90));
        ls.add(new Student(10));
        ls.add(new Student(80));
        List<Student> res = school.collect(ls, st ->  {
            return st.getScore() >= 0 & st.getScore() < 50;
        });
        List<Student> expected = new ArrayList<>();
        expected.add(new Student(20));
        expected.add(new Student(10));
        assertTrue(res.toString().equals(expected.toString()));
    }

    /**
     * тест map
     */
    @Test
    public void whenListToMap() {
        School school =  new School();
        List<Student> ls = new ArrayList<>();
        Student st1 = new Student(50, "Lenhon");
        Student st2 = new Student(20, "Lenin");
        Student st3 = new Student(90, "Stalin");
        ls.add(st1);
        ls.add(st2);
        ls.add(st3);
        Map<String, Student> ms =  school.collectToMap(ls);
        Map<String, Student> expected = new HashMap<>();
        expected.put(st1.getSurname(), st1);
        expected.put(st2.getSurname(), st2);
        expected.put(st3.getSurname(), st3);
        assertTrue(ms.toString().equals(expected.toString()));
    }
}
