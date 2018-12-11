package tracker;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chashkov Alexander
 * Start user interface
 * @version 0.0.0.1
 * @since 2018.12.03
 */
public class StartUI {
    private int[] ranges = new int[Actions.values().length];
    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     *
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
        for (int i = 0; i < ranges.length; i++) {
            ranges[i] = Actions.values()[i].ordinal();
        }
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        List<Integer> range = new ArrayList<>();
        menu.fillActions();
        for (int i = 0; i < menu.getActionsLentgh(); i++) {
            range.add(i);
        }
        boolean exit = false;
        while (!exit) {
            menu.show();
            int answer = input.ask("select:" + range.toString(), this.ranges);
            menu.select(answer);
            exit = answer == Actions.EXIT.ordinal();
        }
    }
    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker()).init();
    }
}
