package pseudo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

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
     * содержит дефолтный вывод в консоль.
     */
    private final PrintStream stdout = System.out;

    /**
     * буфер для результата.
     */
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    private final String sep = System.lineSeparator();

    /**
     * устанавливает поток вывода на буффер
     */
    @Before
    public void loadOutput() throws UnsupportedEncodingException {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out, false, "UTF-8"));
    }

    /**
     * устанавливает поток вывода по умлолчанию
     */
    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }

    /**
     * test draw square
     */
    @Test
    public void whenDrawSquare() throws UnsupportedEncodingException {
        new Paint().draw(new Square());
        StringBuilder expected = new StringBuilder();
        expected.append("█████████").append(this.sep);
        expected.append("█           █").append(this.sep);
        expected.append("█           █").append(this.sep);
        expected.append("█           █").append(this.sep);
        expected.append("█           █").append(this.sep);
        expected.append("█████████").append(this.sep).append(this.sep);
        assertThat(new String(out.toByteArray(), "UTF-8"), is(expected.toString()));
    }

    @Test
    public void whenDrawTriangle() throws UnsupportedEncodingException {
        new Paint().draw(new Triangle());
        StringBuilder expected = new StringBuilder();
        expected.append("      █").append(this.sep);
        expected.append("    █   █").append(this.sep);
        expected.append("  █       █").append(this.sep);
        expected.append("█████████").append(this.sep).append(this.sep);
        assertThat(new String(out.toByteArray(), "UTF-8"), is(expected.toString()));
    }

}
