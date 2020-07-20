package ru.job4j.io;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static java.nio.file.FileVisitResult.CONTINUE;

/**
 * @author Alexander Chashkov
 * @version 0.0.0.1
 * @project junior
 * @since 20.07.2020
 */
public class SearchFiles<Path>  implements FileVisitor<Path> {
    private Predicate<Path> filter;
    private List<Path> paths = new ArrayList<>();

    public SearchFiles(Predicate<Path> filter) {
        this.filter = filter;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (filter.test(file))
            paths.add(file);
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return CONTINUE;
    }


    public List<Path> getPaths() {
        return paths;
    }
}
