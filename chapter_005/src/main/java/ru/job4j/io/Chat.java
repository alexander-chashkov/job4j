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
    private static final List<String> phrases = new ArrayList<>();
    private static final List<String> logMsg = new ArrayList<>();

    private enum Commands {
        CONTINUE("ПРОДОЛЖИТЬ"), STOP("СТОП"), EXIT("ЗАКОНЧИТЬ"), UNKNOWN("НЕИЗВЕСТНО");

        private String description;

        Commands(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }

        public static Commands fromValue(String name) {
            for (final Commands com : values()) {
                if (com.description.equalsIgnoreCase(name)) {
                    return com;
                }
            }
            return UNKNOWN;
        }
    }

    private static void initPhrases(String pathPhrases) {
        try (BufferedReader read = new BufferedReader(new FileReader(pathPhrases))) {
            read.lines().forEach(line -> {
                phrases.add(line);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getRandomPhrase() {
        return phrases.get((1 + (int) (Math.random() * phrases.size())) - 1);
    }

    private static void runChat(String pathLog) {
        boolean hasExit = false;
        boolean hasStop = false;
        Scanner in = new Scanner(System.in);
        while (!hasExit) {
            String str = "";
            if (in.hasNextLine())
                str = in.nextLine();
            if (!str.trim().isEmpty()) {
                switch (Commands.fromValue(str.trim().toUpperCase())) {
                    case CONTINUE:
                        hasStop = false;
                        break;
                    case STOP:
                        hasStop = true;
                        break;
                    case EXIT:
                        hasExit = true;
                        break;
                    default:
                }
                logMsg.add(str);
                if (!hasStop && !hasExit) {
                    String rndStr = getRandomPhrase();
                    System.out.println(rndStr);
                    logMsg.add(rndStr);
                }
            }
        }
        try (PrintWriter out = new PrintWriter(new FileOutputStream(pathLog))) {
            logMsg.stream().forEach(s -> out.println(s));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        if (args.length == 2) {
            initPhrases(args[1]);
            runChat(args[0]);
        }
    }
}

