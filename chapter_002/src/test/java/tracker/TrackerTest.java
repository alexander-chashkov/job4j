package tracker;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

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
    private Item initItem(int number){
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
        assertThat(tt.findAll()[0], is(item1));
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
        Item[] rslt = new Item[2];
        rslt[0] = item1;
        rslt[1] = item2;
        assertThat(tt.findAll(), is(rslt));
    }

    /**
     * test findById
     */
    @Test
    public void whenAddNewItemFindByIdThenNewItem() {
        Item item1 = this.initItem(1);
        Tracker tt = new Tracker();
        tt.add(item1);
        assertThat(tt.findById(item1.getId()), is(item1));
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
        assertThat(tt.findById(item1.getId()).getName(), is(item55.getName()));
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
        Item[] rslt1 = new Item[1];
        rslt1[0] = item1;
        assertThat(tt.findByName("test1"), is(rslt1));
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
        Item[] rslt1 = new Item[3];
        rslt1[0] = item1;
        rslt1[1] = item6;
        rslt1[2] = item6;
        assertThat(tt.findAll(), is(rslt1));
    }
}
