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
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";

    /**
     * Константа меню для показа все заявок
     */
    private static final String SHOW_ALL = "1";

    /**
     * Константа меню для редактирования заявки
     */
    private static final String EDITED = "2";

    /**
     * Константа меню для удаления заявки
     */
    private static final String DELETED = "3";

    /**
     * Константа меню для поиска заявки по идентификатору
     */
    private static final String FIND_BY_ID = "4";

    /**
     * Константа меню для поиска заявки по имени
     */
    private static final String FIND_BY_NAME = "5";

    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";
    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * показывает меню
     */
    private void showMenu() {
        System.out.println("Меню.");
        System.out.println("0. Добавить заявку");
        System.out.println("1. Показать все заявки");
        System.out.println("2. Редактировать заявку");
        System.out.println("3. Удалить заявку");
        System.out.println("4. Найти заявку по идентификатору");
        System.out.println("5. Найти заявку по названию");
        System.out.println("6. Выйти из программы");
    }

    /**
     * Конструтор инициализирующий поля.
     *
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
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
            String answer = input.ask("select:" + range.toString());
            menu.select(Integer.valueOf(answer));
            exit = answer.equals(String.valueOf(Actions.EXIT.ordinal()));
        }
    }
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
