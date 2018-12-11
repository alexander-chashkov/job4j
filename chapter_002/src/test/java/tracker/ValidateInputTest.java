package tracker;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
/**
 *  @version 0.0.0.1
 *  @since 2018.12.11
 *  @author Chashkov Alexander
 *  класс тестов ValidateInputTest
 */
public class ValidateInputTest {
    /**
     * поток вывода в память
     */
    private final ByteArrayOutputStream mem = new ByteArrayOutputStream();

    /**
     * поток вывода в консоль по умолчанию
     */
    private final PrintStream out = System.out;

    @Before
    public void loadMem() {
        System.setOut(new PrintStream(this.mem));
    }

    @After
    public void loadSys() {
        System.setOut(this.out);
    }
    /**
     * invalid test
     */
    @Test
    public void whenInvalidInput() {
        ValidateInput input = new ValidateInput(new StubInput(new String[] {"п", "1"}));
        input.ask("Enter", new int[] {1, 2});
        assertThat(this.mem.toString(), is(String.format("Ошибка. Введите верные данные!%n")));
    }

    /**
     * range invalid test
     */
    @Test
    public void whenInvalidRangeInput() {
        ValidateInput input = new ValidateInput(new StubInput(new String[] {"9", "6"}));
        input.ask("Enter", new int[] {6});
        assertThat(this.mem.toString(), is(String.format("Введите команду из диапазона меню%n")));
    }

    /**
     * valid test
     */
    @Test
    public void whenOneSixInputValid() {
        ValidateInput input = new ValidateInput(new StubInput(new String[] {"1", "6"}));
        input.ask("Enter", new int[] {1, 6});
        assertThat(this.mem.toString(), is(""));
    }
}
