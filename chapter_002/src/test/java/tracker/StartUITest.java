package tracker;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 *  @version 0.0.0.1
 *  @since 2018.12.04
 *  @author Chashkov Alexander
 *  StartUITest
 */
public class StartUITest {
    public static void main(String[] args) {
        Input input = new StubInput(new String[] {});
        new StartUI(input, new Tracker()).init();
    }

    /**
     * test add new item
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Input input = new StubInput(new String[] {"0", "test1", "test description 1", "comments1", "6"});
        Tracker tracker = new Tracker();
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test1"));
    }

    /**
     * test edited
     */
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test2", "description test2", 122L, new String[]{"comments2"}));
        Input input = new StubInput(new String[] {"2", item.getId(), "replaceTest1", "replace test description 1", "replace comments1", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("replaceTest1"));
    }

    /**
     * test deleted
     */
    @Test
    public void whenDeleteThenTrackerHasDeletedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test3", "description tes3", 1223L, new String[]{"comments3"}));
        Item item2 = tracker.add(new Item("test4", "description tes4", 1224L, new String[]{"comments4"}));
        Input input = new StubInput(new String[] {"3", item.getId(), "6"});
        new StartUI(input, tracker).init();
        Item[] items = new Item[]{item2};
        assertThat(tracker.findAll(), is(items));
    }

}
