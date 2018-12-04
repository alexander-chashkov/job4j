package tracker;

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
    private final ConsoleInput input;

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
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        String[] comments = {this.input.ask("Введите комментарии к заявке :")};
        Item item = new Item(name, desc, System.currentTimeMillis(), comments);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

    /**
     * отображает заявку в консоли
     * @param item заявка
     */
    private void showItem(Item item) {
        if (item != null) {
            System.out.println(item.toString());
        }
    }

    /**
     * отображает все заявки
     */
    private void showAll() {
        System.out.println("------------------------ Заявки -------------------");
        for (Item item : this.tracker.findAll()) {
            this.showItem(item);
        }
    }

    /**
     * редактирование заявки
     */
    private void editItem() {
        System.out.println("-------------Редактирование заявки -----------------");
        String id = this.input.ask("Введите идентификатор заявки: ");
        Item item = this.tracker.findById(id);
        if (item == null) {
            System.out.println("Заявка с таким идентификатором не найдена!");
        } else {
            this.showItem(item);
            item.setName(this.input.ask("Введите новое имя для заявки: "));
            item.setDesc(this.input.ask("Введите новое описание для заявки: "));
            item.setComments(new String[]{this.input.ask("Введите комментарии для заявки: ")});
            if (this.tracker.replace(id, item)) {
                System.out.println("Заявка отредактирована.");
            } else {
                System.out.println("Ошибка. Изменения не применены.");
            }
        }
    }

    /**
     * удаление заявки
     */
    private void deleteItem() {
        System.out.println("-------------Удаление заявки -----------------------");
        String id = this.input.ask("Введите идентификатор заявки: ");
        if (tracker.delete(id)) {
            System.out.println("Заявка с индентификатором " + id + " удалена!");
        } else {
            System.out.println("Не удалось удалить заявку. Не найдена.");
        }
    }

    /**
     * поиск заявки по идентификатору
     */
    private void findById() {
        System.out.println("-------------Поиск заявки --------------------------");
        String id = this.input.ask("Введите идентификатор заявки: ");
        Item item = tracker.findById(id);
        if (item != null) {
            this.showItem(item);
        } else {
            System.out.println("Заявка с индентификатором " + id + " не найдена!");
        }
    }

    /**
     * поиск заявки по имени
     */
    private void findByName() {
        System.out.println("-------------Поиск заявки --------------------------");
        String name = this.input.ask("Введите название заявки: ");
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            System.out.println("-------------заявка -----------------------------");
            for (Item item : items) {
                this.showItem(item);
            }
        } else {
            System.out.println("Заявки с таким именем не найдены. ");
        }
    }

    /**
     * Конструтор инициализирующий поля.
     *
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(ConsoleInput input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (SHOW_ALL.equals(answer)) {
                this.showAll();
            } else if (EDITED.equals(answer)) {
                this.editItem();
            } else if (DELETED.equals(answer)) {
                this.deleteItem();
            } else if (FIND_BY_ID.equals(answer)) {
                this.findById();
            } else if (FIND_BY_NAME.equals(answer)) {
                this.findByName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
