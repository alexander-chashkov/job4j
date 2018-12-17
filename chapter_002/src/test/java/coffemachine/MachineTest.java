package coffemachine;
import coffeemachine.Machine;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 *  @version 0.0.0.1
 *  @since 2018.12.17
 *  @author Chashkov Alexander
 * Machine tests
 */
public class MachineTest {
    /**
     * price 35, money 50
     */
    @Test
    public void whenPrice35Money50ThenChange105() {
        Machine m = new Machine();
        int[] expected = m.changes(50, 35);
        int[] result = new int[] {10, 5};
        assertThat(result, is(expected));
    }

    /**
     * price 26, money 50
     */
    @Test
    public void whenPrice26Money50ThenChange101022() {
        Machine m = new Machine();
        int[] expected = m.changes(50, 26);
        int[] result = new int[] {10, 10, 2, 2};
        assertThat(result, is(expected));
    }

    /**
     * price 26, money 50
     */
    @Test
    public void whenPrice26Money50ThenChange777111() {
        Machine m = new Machine(new int[]{7, 5, 1});
        int[] expected = m.changes(50, 26);
        int[] result = new int[] {7, 7, 7, 1, 1, 1};
        assertThat(result, is(expected));
    }
}
