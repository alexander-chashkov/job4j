package ru.job4j.io;

/**
 * @author Alexander Chashkov
 * @version 0.0.0.1
 * @project junior
 * @since 14.07.2020
 */
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class Analizy {
    private List<String> nonWorkStatusList = Arrays.asList("400", "500");

    public void unavailable(String source, String target) {
        try (BufferedReader read = new BufferedReader(new FileReader(source))) {
            try (PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
                List<String> result = new ArrayList<>();

                AtomicReference<Boolean> notWork = new AtomicReference<>(false);

                read.lines().forEach(line -> {
                    if (!line.isEmpty() && !line.isBlank()) {
                        String[] strs = line.split(" ");
                        if (nonWorkStatusList.stream().anyMatch(st -> st.equals(strs[0]))) {
                            if (!notWork.get()) {
                                out.print(strs[1]);
                                notWork.set(true);
                            }
                        } else {
                            if (notWork.get()) {
                                out.println(";" + strs[1]);
                                notWork.set(false);
                            }
                        }
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
            out.println("15:01:30;15:02:32");
            out.println("15:10:30;23:12:32");
        } catch (Exception e) {
            e.printStackTrace();
        }
        new Analizy().unavailable("C:\\projects\\job4j\\chapter_005\\src\\main\\java\\ru\\job4j\\io\\log.log", "C:\\projects\\job4j\\chapter_005\\src\\main\\java\\ru\\job4j\\io\\unavailable2.csv");
}
}