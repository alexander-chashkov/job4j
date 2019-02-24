package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
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
        List<Student> res = school.collect(ls, school.isAClass());
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
        List<Student> res = school.collect(ls, school.isBClass());
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
        List<Student> res = school.collect(ls, school.isVClass());
        List<Student> expected = new ArrayList<>();
        expected.add(new Student(20));
        expected.add(new Student(10));
        assertTrue(res.toString().equals(expected.toString()));
    }
}
