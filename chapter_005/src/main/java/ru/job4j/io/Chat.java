package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Alexander Chashkov
 * @version 0.0.0.1
 * @project junior
 * @since 06.08.2020
 */
public class Chat {
    private static final String pathLog = "./chapter_005/src/main/java/ru/job4j/io/chat/log.log";
    private static final String pathPhrases = "./chapter_005/src/main/java/ru/job4j/io/chat/phrases.txt";
    private static final List<String> phrases = new ArrayList<>();

    private static void initPhrases() {
        try (BufferedReader read = new BufferedReader(new FileReader(pathPhrases))) {
            read.lines().forEach(line -> {
                phrases.add(line);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        initPhrases();
        boolean hasExit = false;
        boolean hasStop = false;
        Scanner in = new Scanner(System.in);
        try (PrintWriter out = new PrintWriter(new FileOutputStream(pathLog))) {
            while (!hasExit) {
                String str = "";
                if (in.hasNextLine())
                    str = in.nextLine();
                if (!str.trim().isEmpty()) {
                    switch (str.trim().toUpperCase()) {
                        case "ПРОДОЛЖИТЬ":
                            hasStop = false;
                            break;
                        case "СТОП":
                            hasStop = true;
                            break;
                        case "ЗАКОНЧИТЬ":
                            hasExit = true;
                            break;
                        default:
                    }
                    out.println(str);
                    if (!hasStop && !hasExit) {
                        int index = (1 + (int) (Math.random() * phrases.size())) - 1;
                        System.out.println(phrases.get(index));
                        out.println(phrases.get(index));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

