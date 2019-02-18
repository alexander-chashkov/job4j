package tracker;
import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 *  @version 0.0.0.1
 *  @since 2018.12.04
 *  @author Chashkov Alexander
 *  StartUITest
 */
public class StartUITest {
    /**
     * содержит дефолтный вывод в консоль.
     */
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final Consumer<String> output = new Consumer<String>() {
        private final PrintStream stdout = new PrintStream(out);

        @Override
        public void accept(String s) {
            stdout.println(s);
        }
    };
    /**
     * буфер для результата.
     */


    private final String sep = System.lineSeparator();

    @Before
    public void loadOutput() {
        //System.setOut(new PrintStream(this.out));
    }

    /**
     * устанавливает поток вывода по умлолчанию
     */
    @After
    public void backOutput() {
        //System.setOut(this.stdout);
    }

    public static void main(String[] args) {
        Input input = new StubInput(new String[] {"1", "6"});
        new StartUI(input, new Tracker(), System.out::println).init();
    }

    /**
     * test add new item
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Input input = new StubInput(new String[] {"0", "test1", "test description 1", "comments1", "6"});
        Tracker tracker = new Tracker();
        new StartUI(input, tracker, output).init();
        assertThat(tracker.findAll().get(0).getName(), is("test1"));
    }

    /**
     * test edited
     */
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test2", "description test2", 122L, new String[]{"comments2"}));
        Input input = new StubInput(new String[] {"2", item.getId(), "replaceTest1", "replace test description 1", "replace comments1", "6"});
        new StartUI(input, tracker, output).init();
        assertThat(tracker.findAll().get(0).getName(), is("replaceTest1"));
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
        new StartUI(input, tracker, output).init();
        ArrayList<Item> items = new ArrayList<>();
        items.add(item2);
        assertThat(tracker.findAll(), is(items));
    }

    /**
     * @return ожидаемое меню
     */
    private StringBuilder getExpectedMenu() {
        StringBuilder result = new StringBuilder();
        result.append("Меню.").append(this.sep);
        result.append("0. Добавить заявку").append(this.sep);
        result.append("1. Показать все заявки").append(this.sep);
        result.append("2. Редактировать заявку").append(this.sep);
        result.append("3. Удалить заявку").append(this.sep);
        result.append("4. Найти заявку по идентификатору").append(this.sep);
        result.append("5. Найти заявку по названию").append(this.sep);
        result.append("6. Выйти из программы").append(this.sep);
        return result;
    }

    /**
     * @return ожидаемая заявка
     */
    private StringBuilder getExpectedItem(Item item) {
        StringBuilder result = new StringBuilder();
        result.append("------------------------ Заявка -------------------").append(this.sep);
        result.append("------------------------ Идентификатор : ").append(item.getId()).append(this.sep);
        result.append("Название : ").append(item.getName()).append(this.sep);
        result.append("Описание : ").append(item.getDesc()).append(this.sep);
        Instant instant = Instant.ofEpochMilli(item.getCreated());
        result.append("Дата и время создания: ").append(instant.toString()).append(this.sep);
        result.append("Комментарии : ").append(Arrays.toString(item.getComments())).append(this.sep);
        result.append("---------------------------------------------------").append(this.sep);
        return result;
    }

    /**
     * test show menu
     */
    @Test
    public void whenMenuItemThenShowMenu() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[] {"6"});
        new StartUI(input, tracker, output).init();
        StringBuilder expected = new StringBuilder();
        expected.append(this.getExpectedMenu());
        assertThat(new String(this.out.toByteArray()), is(expected.toString()));

    }

    /**
     * test show all item
     */
    @Test
    public void whenAddOneItemAndShowAllItemThenShowAllItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test5", "description tes5", 156623L, new String[]{"comments5"}));
        Item item2 = tracker.add(new Item("test6", "description tes6", 1656623L, new String[]{"comments6"}));
        Input input = new StubInput(new String[] {"1", "6"});
        new StartUI(input, tracker, output).init();
        StringBuilder expected = new StringBuilder();
        expected.append(this.getExpectedMenu().append("------------------------ Заявки -------------------").append(this.sep));
        expected.append(this.getExpectedItem(item).append(this.getExpectedItem(item2)));
        expected.append(this.getExpectedMenu());
        assertThat(new String(this.out.toByteArray()), is(expected.toString()));

    }

}
