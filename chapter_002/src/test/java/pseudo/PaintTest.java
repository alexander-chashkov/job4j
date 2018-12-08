package pseudo;

import org.junit.After;
import org.junit.Before;
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
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
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
    public void whenDrawSquare() {
        new Paint().draw(new Square());
        StringBuilder expected = new StringBuilder();
        expected.append("█████████").append(this.sep);
        expected.append("█           █").append(this.sep);
        expected.append("█           █").append(this.sep);
        expected.append("█           █").append(this.sep);
        expected.append("█           █").append(this.sep);
        expected.append("█████████").append(this.sep).append(this.sep);
        assertThat(new String(out.toByteArray()), is(expected.toString()));
    }

    @Test
    public void whenDrawTriangle() {
        new Paint().draw(new Triangle());
        StringBuilder expected = new StringBuilder();
        expected.append("      █").append(this.sep);
        expected.append("    █   █").append(this.sep);
        expected.append("  █       █").append(this.sep);
        expected.append("█████████").append(this.sep).append(this.sep);
        assertThat(new String(out.toByteArray()), is(expected.toString()));
    }

}
