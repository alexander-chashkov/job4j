package ru.job4j.io;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Alexander Chashkov
 * @version 0.0.0.1
 * @project junior
 * @since 20.07.2020
 */
public class AnalizyTest {
    @Test
    public void when2RecUnvServ() {
        String path = "C:\\projects\\job4j\\chapter_005\\src\\main\\java\\ru\\job4j\\io\\unavailable2.csv";
        StringBuilder result = new StringBuilder();
        try (BufferedReader read = new BufferedReader(new FileReader(path))) {
            read.lines().forEach(line -> {
               result.append(line + "\n");
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertThat(result.toString(), is("10:57:01;10:59:01\n" +
                "11:01:02;11:02:02\n"));
    }
}
