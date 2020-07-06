package ru.job4j.io;

import java.io.FileInputStream;

/**
 * @author Alexander Chashkov
 * @version 0.0.0.1
 * @project junior
 * @since 03.07.2020
 */
public class ReadFile {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("C:\\projects\\job4j\\chapter_005\\src\\main\\java\\ru\\job4j\\io\\input.txt")) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }
            System.out.println(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}