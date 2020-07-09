package ru.job4j.io;

/**
 * @author Alexander Chashkov
 * @version 0.0.0.1
 * @project junior
 * @since 09.07.2020
 */
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ConfigTest {

    @Test
    public void whenPairWithoutComment() {
        String path = "./data/test.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name"), is("Petr Arsentev"));
    }

    @Test
    public void whenPairWithCommentAndEmptyLines() {
        String path = "./data/test2.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name"), is("Alexandro"));
        assertThat(config.value("location"), is("Orenburg"));
    }
}
