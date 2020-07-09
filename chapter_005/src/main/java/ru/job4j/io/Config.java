package ru.job4j.io;

/**
 * @author Alexander Chashkov
 * @version 0.0.0.1
 * @project junior
 * @since 09.07.2020
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<String, String>();
    private final String charForComment = "##";
    private final String delimiter = "=";

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(line -> {
                if (!line.isEmpty() && !line.isBlank() && !line.substring(0, charForComment.length()).equals(charForComment)) {
                    String[] strs = line.split(delimiter);
                    values.put(strs[0], strs.length > 1 ? strs[1] : "");
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        return values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Config("app.properties"));
    }
}