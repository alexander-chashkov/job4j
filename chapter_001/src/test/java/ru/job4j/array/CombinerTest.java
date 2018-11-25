package ru.job4j.array;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 *  тест Combiner test
 *  @version 0.0.0.1
 *  @author Chashkov Alexander
 *  @since 2018.11.25
 */
public class CombinerTest {

    /**
     * test 1
     */
    @Test
    public void whenArr12345Arr2489Then122344589() {
        Combiner combiner = new Combiner();
        int[] arr1 = new int[] {1, 2, 3, 4, 5};
        int[] arr2 = new int[] {2, 4, 8, 9};
        int[] rst = combiner.toCombine(arr1, arr2);
        int[] expect = new int[]{1, 2, 2, 3, 4, 4, 5, 8, 9};
        assertThat(rst, is(expect));
    }

    /**
     * test 2
     */
    @Test
    public void whenArr0Arr0Then00() {
        Combiner combiner = new Combiner();
        int[] arr1 = new int[] {0};
        int[] arr2 = new int[] {0};
        int[] rst = combiner.toCombine(arr1, arr2);
        int[] expect = new int[]{0, 0};
        assertThat(rst, is(expect));
    }
    /**
     * test 3
     */
    @Test
    public void whenArr112Arr1Then1112() {
        Combiner combiner = new Combiner();
        int[] arr1 = new int[] {1, 1, 2};
        int[] arr2 = new int[] {1};
        int[] rst = combiner.toCombine(arr1, arr2);
        int[] expect = new int[]{1, 1, 1, 2};
        assertThat(rst, is(expect));
    }

    /**
     * test 4
     */
    @Test
    public void whenArr1589Arr2234Then12234589() {
        Combiner combiner = new Combiner();
        int[] arr1 = new int[] {1, 5,  8, 9};
        int[] arr2 = new int[] {2, 2, 3, 4};
        int[] rst = combiner.toCombine(arr1, arr2);
        int[] expect = new int[]{1, 2, 2, 3, 4, 5, 8, 9};
        assertThat(rst, is(expect));
    }

    /**
     * test 5
     */
    @Test
    public void whenArr2ArrThen2() {
        Combiner combiner = new Combiner();
        int[] arr1 = new int[] {2};
        int[] arr2 = new int[] {};
        int[] rst = combiner.toCombine(arr1, arr2);
        int[] expect = new int[]{2};
        assertThat(rst, is(expect));
    }
}
