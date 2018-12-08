package pseudo;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 *  @version 0.0.0.1
 *  @since 2018.12.08
 *  @author Chashkov Alexander
 *  TriangleTest
 */
public class TriangleTest {
    /**
     * test for triangle
     */
    @Test
    public void whenDrawTriangle() {
        String sep = System.lineSeparator();
        Triangle tri = new Triangle();
        StringBuilder expected = new StringBuilder();
        expected.append("      █").append(sep);
        expected.append("    █   █").append(sep);
        expected.append("  █       █").append(sep);
        expected.append("█████████").append(sep);
        assertThat(tri.draw(), is(expected.toString()));
    }
}
