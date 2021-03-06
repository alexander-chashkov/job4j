package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author Alexander Chashkov
 * @version 0.0.0.1
 * @project junior
 * @since 26.07.2020
 */
public class Zip {
    public void packFiles(List<File> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            sources.stream().forEach(s -> {
                try {
                    zip.putNextEntry(new ZipEntry(s.getPath()));
                    BufferedInputStream out = new BufferedInputStream(new FileInputStream(s));
                    zip.write(out.readAllBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<File> searchFiles(ArgZip az) throws IOException  {
        SearchFiles<Path> seacher = new SearchFiles<>(p -> !p.toFile().getName().endsWith(az.exclude()));
        Files.walkFileTree(Paths.get(az.directory()), seacher);
        return seacher.getPaths().stream().map(p -> p.toFile()).collect(Collectors.toCollection(ArrayList::new));
    }

    public static void main(String[] args) {
        new Zip().packSingleFile(
                new File("./chapter_005/pom.xml"),
                new File("./chapter_005/pom.zip")
        );
        ArgZip az = new ArgZip(args);
        try {
            if (az.valid()) {
                Zip zip = new Zip();
                zip.packFiles(zip.searchFiles(az), new File(az.output()));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
