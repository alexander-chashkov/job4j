package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author Alexander Chashkov
 * @version 0.0.0.1
 * @project junior
 * @since 20.07.2020
 */
public class Search {
    public static void main(String[] args) throws IOException {
        Path start = Paths.get("C:\\projects\\job4j\\chapter_005\\src\\main\\java\\ru\\job4j\\io\\");
        //Files.walkFileTree(start, new PrintFiles());
        System.out.println(search(start, "log").toString());
    }

    public static List<Path> search(Path root, String ext) throws IOException {
        SearchFiles<Path> seacher = new SearchFiles<>(p -> p.toFile().getName().endsWith(ext));
        Files.walkFileTree(root, seacher);
        return seacher.getPaths();
    }
}
