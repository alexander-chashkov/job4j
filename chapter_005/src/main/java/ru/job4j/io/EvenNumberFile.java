package ru.job4j.io;

import java.io.FileInputStream;

/**
 * @author Alexander Chashkov
 * @version 0.0.0.1
 * @project junior
 * @since 07.07.2020
 */
public class EvenNumberFile {
    private static boolean isEvenNumber(int val) {
        return val % 2 == 0;
    }

    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("C:\\projects\\job4j\\chapter_005\\src\\main\\java\\ru\\job4j\\io\\even.txt")) {
            int read;
            while ((read = in.read()) != -1) {
                System.out.println(read + " " + isEvenNumber(read));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
