package tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

class DeleteItem extends BaseAction {
    public DeleteItem(int key, String name) {
        super(key, name);
    }
    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("-------------Удаление заявки -----------------------");
        String id = input.ask("Введите идентификатор заявки: ");
        if (tracker.delete(id)) {
            System.out.println("Заявка с индентификатором " + id + " удалена!");
        } else {
            System.out.println("Не удалось удалить заявку. Не найдена.");
        }
    }
}

/**
 * @author Chashkov Alexander
 * @version 0.0.0.1
 * @since 2018.12.09
 * MenuTracker
 */
public class MenuTracker {
    /**
     * ввод
     */
    private Input input;
    /**
     * трэкер для хранения заявок
     */
    private Tracker tracker;
    /**
     * события/операции над заявками
     */
    private List<UserAction> actions = new ArrayList<>();
    private final Consumer<String> output;

    /**
     * Конструктор.
     *
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     */
    public MenuTracker(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

    /**
     * Метод для получения массива меню.
     * @return длину массива
     */
    public int getActionsLentgh() {
        return this.actions.size();
    }

    /**
     * Метод заполняет массив.
     */
    public void fillActions(StartUI ui) {
        this.actions.add(this.new AddItem(Actions.ADD.ordinal(), ". Добавить заявку"));
        this.actions.add(this.new ShowItems(Actions.SHOW_ALL.ordinal(), ". Показать все заявки"));
        this.actions.add(this.new UpdateItem(Actions.EDITED.ordinal(), ". Редактировать заявку"));
        this.actions.add(new DeleteItem(Actions.DELETED.ordinal(), ". Удалить заявку"));
        this.actions.add(new MenuTracker.FindItemById(Actions.FIND_BY_ID.ordinal(), ". Найти заявку по идентификатору"));
        this.actions.add(this.new FindItemsByName(Actions.FIND_BY_NAME.ordinal(), ". Найти заявку по названию"));
        this.actions.add(this.new ExitProgram(Actions.EXIT.ordinal(), ". Выйти из программы", ui));
    }

    /**
     * Метод в зависимости от указанного ключа, выполняет соотвествующие действие.
     *
     * @param key ключ операции
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    public void show() {
        output.accept("Меню.");
        for (UserAction action : this.actions) {
            if (action != null) {
                output.accept(action.info());
            }
        }
    }

    /**
     * @author Chashkov Alexander
     * @version 0.0.0.1
     * @since 2018.12.09
     * AddItem
     */
    private class AddItem extends BaseAction {
        public AddItem(int key, String name) {
            super(key, name);
        }
        /**
         * метод добавления заявки
         *
         * @param input   приглашение для ввода
         * @param tracker tracker хранилище заявок
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("------------ Добавление новой заявки --------------");
            String name = input.ask("Введите имя заявки :");
            String desc = input.ask("Введите описание заявки :");
            String[] comments = {input.ask("Введите комментарии к заявке :")};
            Item item = new Item(name, desc, System.currentTimeMillis(), comments);
            tracker.add(item);
            output.accept("------------ Новая заявка с getId : " + item.getId() + "-----------");
        }
    }

        private class ShowItems extends BaseAction {
            public ShowItems(int key, String name) {
                super(key, name);
            }
            /**
             * метод отображения всех заявок
             * @param input приглашение для ввода
             * @param tracker tracker хранилище заявок
             */
            @Override
            public void execute(Input input, Tracker tracker) {
                output.accept("------------------------ Заявки -------------------");
                for (Item item : tracker.findAll()) {
                    if (item != null) {
                        output.accept(item.toString());
                    }
                }
            }
        }

    /**
     * @author Chashkov Alexander
     * @version 0.0.0.1
     * @since 2018.12.09
     * AddItem
     */
    private class UpdateItem extends BaseAction {
        public UpdateItem(int key, String name) {
            super(key, name);
        }
        /**
         * метод редактирования заявки
         *
         * @param input   приглашение для ввода
         * @param tracker tracker хранилище заявок
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("-------------Редактирование заявки -----------------");
            String id = input.ask("Введите идентификатор заявки: ");
            Item item = tracker.findById(id);
            if (item == null) {
                output.accept("Заявка с таким идентификатором не найдена!");
            } else {
                output.accept(item.toString());
                item.setName(input.ask("Введите новое имя для заявки: "));
                item.setDesc(input.ask("Введите новое описание для заявки: "));
                item.setComments(new String[]{input.ask("Введите комментарии для заявки: ")});
                if (tracker.replace(id, item)) {
                    output.accept("Заявка отредактирована.");
                } else {
                    output.accept("Ошибка. Изменения не применены.");
                }
            }
        }
    }

    private  class FindItemById extends BaseAction {
        public FindItemById(int key, String name) {
            super(key, name);
        }
        /**
         * метод поиска заявки по идентификатору
         * @param input приглашение для ввода
         * @param tracker tracker хранилище заявок
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("-------------Поиск заявки --------------------------");
            String id = input.ask("Введите идентификатор заявки: ");
            Item item = tracker.findById(id);
            if (item != null) {
                output.accept(item.toString());
            } else {
                output.accept("Заявка с индентификатором " + id + " не найдена!");
            }
        }
    }

    private class FindItemsByName extends BaseAction {
        public FindItemsByName(int key, String name) {
            super(key, name);
        }
        /**
         * метод поиска заявки по названию
         * @param input приглашение для ввода
         * @param tracker tracker хранилище заявок
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("-------------Поиск заявки --------------------------");
            String name = input.ask("Введите название заявки: ");
            List<Item> items = tracker.findByName(name);
            if (items.size() > 0) {
                output.accept("-------------заявка -----------------------------");
                for (Item item : items) {
                    if (item != null) {
                        output.accept(item.toString());
                    }
                }
            } else {
                output.accept("Заявки с таким именем не найдены. ");
            }
        }
    }

    private class ExitProgram extends BaseAction {
        private final StartUI ui;
        public ExitProgram(int key, String name, StartUI ui) {
            super(key, name);
            this.ui = ui;
        }
        /**
         * метод выхода из программы
         * @param input приглашение для ввода
         * @param tracker tracker хранилище заявок
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            this.ui.stop();
        }
    }
}

