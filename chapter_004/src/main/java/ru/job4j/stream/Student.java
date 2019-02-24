package ru.job4j.stream;
/**
 *  @version 0.0.0.1
 *  @since 2019.02.24
 *  @author Chashkov Alexander
 *  Класс ученик
 */
public class Student {
    /**
     * общий балл
     */
    private int score;

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Student(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" + "score=" + score + '}';
    }
}
