package pseudo;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.Charset;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 *  @version 0.0.0.1
 *  @since 2018.12.08
 *  @author Chashkov Alexander
 *  PaintTest
 */
public class PaintTest {
    /**
     * test draw square
     */
    @Test
    public void whenDrawSquare() {

        String sep = System.lineSeparator();
        PrintStream stdout = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new Paint().draw(new Square());
        StringBuilder expected = new StringBuilder();
        expected.append("█████████").append(sep);
        expected.append("█           █").append(sep);
        expected.append("█           █").append(sep);
        expected.append("█           █").append(sep);
        expected.append("█           █").append(sep);
        expected.append("█████████").append(sep).append(sep);
        assertThat(new String(out.toByteArray()), is(expected.toString()));
        System.setOut(stdout);
    }

    @Test
    public void whenDrawTriangle() {
        String sep = System.lineSeparator();
        PrintStream stdout = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new Paint().draw(new Triangle());
        StringBuilder expected = new StringBuilder();
        expected.append("      █").append(sep);
        expected.append("    █   █").append(sep);
        expected.append("  █       █").append(sep);
        expected.append("█████████").append(sep);
        expected.append(sep);
        assertThat(new String(out.toByteArray()), is(expected.toString()));
        System.setOut(stdout);
    }

}
