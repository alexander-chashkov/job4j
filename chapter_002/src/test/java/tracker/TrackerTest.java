package tracker;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 *  @version 0.0.0.1
 *  @since 2018.12.02
 *  @author Chashkov Alexander
 *  класс тестов Tracker
 */
public class TrackerTest {

    /**
     * @param number номер заявки для тестирования
     * @return заявка
     */
    private Item initItem(int number) {
        String[] comments = new String[1];
        comments[0] = "comennts test" + number;
        return new Item("test" + number, "testDescr" + number, 123L, comments);
    }
    /**
     * test add
     */
    @Test
    public void whenAddNewOneItemThenTrackerHasSameItem() {
        Item item1 = this.initItem(1);
        Tracker tt = new Tracker();
        tt.add(item1);
        assertTrue(tt.findAll().get(0).equals(item1));
    }

    /**
     * test findAll
     */
    @Test
    public void whenAddNewTwoItemThenFindAllTwoItem() {
        Item item1 = this.initItem(1);
        Item item2 = this.initItem(2);
        Tracker tt = new Tracker();
        tt.add(item1);
        tt.add(item2);
        ArrayList<Item> rslt = new ArrayList();
        rslt.add(item1);
        rslt.add(item2);
        assertTrue(tt.findAll().equals(rslt));
    }

    /**
     * test findById
     */
    @Test
    public void whenAddNewItemFindByIdThenNewItem() {
        Item item1 = this.initItem(1);
        Tracker tt = new Tracker();
        tt.add(item1);
        assertTrue(tt.findById(item1.getId()).equals(item1));
    }

    /**
     * test replace
     */
    @Test
    public void whenReplaceOneItemOnTwoItemThenByIdTwoItem() {
        Item item1 = this.initItem(1);
        Item item55 = this.initItem(55);
        Tracker tt = new Tracker();
        tt.add(item1);
        tt.replace(item1.getId(), item55);
        assertTrue(tt.findById(item55.getId()).equals(item55));
    }

    /**
     * test FindByName
     */
    @Test
    public void whenFindByNameTest1ThenAllItemTest1Name() {
        Item item1 = this.initItem(1);
        Item item4 = this.initItem(4);
        Tracker tt = new Tracker();
        tt.add(item1);
        tt.add(item4);
        ArrayList<Item> rslt1 = new ArrayList();
        rslt1.add(item1);
        assertTrue(tt.findByName("test1").equals(rslt1));
    }

    /**
     * test delete
     */
    @Test
    public void whenDeleteTest4ThenTest1Test6() {
        Item item1 = this.initItem(1);
        Item item4 = this.initItem(4);
        Item item6 = this.initItem(6);
        Tracker tt = new Tracker();
        tt.add(item1);
        tt.add(item4);
        tt.add(item6);
        tt.add(item6);
        tt.delete(item4.getId());
        ArrayList<Item> rslt1 = new ArrayList<>();
        rslt1.add(item1);
        rslt1.add(item6);
        rslt1.add(item6);
        assertTrue(tt.findAll().equals(rslt1));
    }
}
