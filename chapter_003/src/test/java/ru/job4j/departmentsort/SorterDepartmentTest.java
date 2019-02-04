package ru.job4j.departmentsort;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 *  @version 0.0.0.1
 *  @since 2019.02.03
 *  @author Chashkov Alexander
 *  тесты для SorterTest
 */
public class SorterDepartmentTest {
    @Test
    /**
     * test1 as task asc
     * тесты как и задания
     */
    public void whenAsTask() {
        SorterDepartment sd = new SorterDepartment();
        sd.addDepartment("K1\\SK1");
        sd.addDepartment("K1\\SK2");
        sd.addDepartment("K1\\SK1\\SSK1");
        sd.addDepartment("K1\\SK1\\SSK2");
        sd.addDepartment("K2");
        sd.addDepartment("K2\\SK1\\SSK1");
        sd.addDepartment("K2\\SK1\\SSK2");
        sd.clearResult();
        sd.showElements(sd.getDepartments().getChildDps(), "");
        String result = "K1" + System.lineSeparator()
                + "K1\\SK1" + System.lineSeparator()
                + "K1\\SK1\\SSK1" + System.lineSeparator()
                + "K1\\SK1\\SSK2" + System.lineSeparator()
                + "K1\\SK2" + System.lineSeparator()
                + "K2" + System.lineSeparator()
                + "K2\\SK1" + System.lineSeparator()
                + "K2\\SK1\\SSK1" + System.lineSeparator()
                + "K2\\SK1\\SSK2" + System.lineSeparator();
        assertEquals(result, sd.getResult());
    }

    @Test
    /**
     * test2 as task asc
     * тесты как и задания
     */
    public void whenAsTaskDesc() {
        SorterDepartment sd = new SorterDepartment();
        sd.addDepartment("K1\\SK1");
        sd.addDepartment("K1\\SK2");
        sd.addDepartment("K1\\SK1\\SSK1");
        sd.addDepartment("K1\\SK1\\SSK2");
        sd.addDepartment("K2");
        sd.addDepartment("K2\\SK1\\SSK1");
        sd.addDepartment("K2\\SK1\\SSK2");
        sd.clearResult();
        sd.showElementsDesc(sd.getDepartments().getChildDps(), "");
        String result = "K2" + System.lineSeparator()
                + "K2\\SK1" + System.lineSeparator()
                + "K2\\SK1\\SSK2" + System.lineSeparator()
                + "K2\\SK1\\SSK1" + System.lineSeparator()
                + "K1" + System.lineSeparator()
                + "K1\\SK2" + System.lineSeparator()
                + "K1\\SK1" + System.lineSeparator()
                + "K1\\SK1\\SSK2" + System.lineSeparator()
                + "K1\\SK1\\SSK1" + System.lineSeparator();
        assertEquals(result, sd.getResult());
    }

    @Test
    /**
     * test2 as task asc
     */
    public void whenTest() {
        SorterDepartment sd = new SorterDepartment();
        sd.addDepartment("K2\\SK1\\SSK1\\cluster1\\server45");
        sd.addDepartment("K1");
        sd.addDepartment("K1\\SK1");
        sd.addDepartment("K1\\SK1\\SSK1");
        sd.addDepartment("K1\\SK1\\SSK2");
        sd.addDepartment("K1\\SK2");
        sd.addDepartment("K2");
        sd.addDepartment("K2\\SK1");
        sd.addDepartment("K2\\SK1\\SSK1\\cluster2\\server44\\t1\\g7\\p15");
        sd.addDepartment("K2\\SK1\\SSK1\\cluster3\\server44");
        sd.addDepartment("K2\\SK1\\SSK2");
        sd.clearResult();
        sd.showElementsDesc(sd.getDepartments().getChildDps(), "");
        String result = "K2" + System.lineSeparator()
                + "K2\\SK1" + System.lineSeparator()
                + "K2\\SK1\\SSK2" + System.lineSeparator()
                + "K2\\SK1\\SSK1" + System.lineSeparator()
                + "K2\\SK1\\SSK1\\cluster2" + System.lineSeparator()
                + "K2\\SK1\\SSK1\\cluster2\\server44" + System.lineSeparator()
                + "K2\\SK1\\SSK1\\cluster2\\server44\\t1" + System.lineSeparator()
                + "K2\\SK1\\SSK1\\cluster2\\server44\\t1\\g7" + System.lineSeparator()
                + "K2\\SK1\\SSK1\\cluster2\\server44\\t1\\g7\\p15" + System.lineSeparator()
                + "K2\\SK1\\SSK1\\cluster3" + System.lineSeparator()
                + "K2\\SK1\\SSK1\\cluster3\\server44" + System.lineSeparator()
                + "K2\\SK1\\SSK1\\cluster1" + System.lineSeparator()
                + "K2\\SK1\\SSK1\\cluster1\\server45" + System.lineSeparator()
                + "K1" + System.lineSeparator()
                + "K1\\SK2" + System.lineSeparator()
                + "K1\\SK1" + System.lineSeparator()
                + "K1\\SK1\\SSK2" + System.lineSeparator()
                + "K1\\SK1\\SSK1" + System.lineSeparator();
        assertEquals(result, sd.getResult());
    }



}
