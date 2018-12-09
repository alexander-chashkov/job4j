package tracker;

import java.util.ArrayList;
import java.util.List;

class DeleteItem implements UserAction {

    @Override
    public int key() {
        return Actions.DELETED.ordinal();
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

    @Override
    public String info() {
        return String.format("%s%s", this.key(), ". Удалить заявку");
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
     * @param хранит ссылку на объект .
     */
    private Input input;
    /**
     * @param хранит ссылку на объект .
     */
    private Tracker tracker;
    /**
     * @param хранит ссылку на массив типа UserAction.
     */
    private List<UserAction> actions = new ArrayList<>();

    /**
     * Конструктор.
     *
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
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
    public void fillActions() {
        this.actions.add(this.new AddItem());
        this.actions.add(this.new ShowItems());
        this.actions.add(this.new UpdateItem());
        this.actions.add(new DeleteItem());
        this.actions.add(new MenuTracker.FindItemById());
        this.actions.add(this.new FindItemsByName());
        this.actions.add(this.new ExitProgram());
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
        System.out.println("Меню.");
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    /**
     * @author Chashkov Alexander
     * @version 0.0.0.1
     * @since 2018.12.09
     * AddItem
     */
    private class AddItem implements UserAction {
        /**
         * @return ключ действия
         */
        @Override
        public int key() {
            return Actions.ADD.ordinal();
        }

        /**
         * метод добавления заявки
         *
         * @param input   приглашение для ввода
         * @param tracker tracker хранилище заявок
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Добавление новой заявки --------------");
            String name = input.ask("Введите имя заявки :");
            String desc = input.ask("Введите описание заявки :");
            String[] comments = {input.ask("Введите комментарии к заявке :")};
            Item item = new Item(name, desc, System.currentTimeMillis(), comments);
            tracker.add(item);
            System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
        }

        /**
         * @return информация
         */
        @Override
        public String info() {
            return String.format("%s%s", this.key(), ". Добавить заявку");
        }
    }

        private class ShowItems implements UserAction {
            /**
             * @return ключ действия
             */
            @Override
            public int key() {
                return Actions.SHOW_ALL.ordinal();
            }

            /**
             * метод отображения всех заявок
             * @param input приглашение для ввода
             * @param tracker tracker хранилище заявок
             */
            @Override
            public void execute(Input input, Tracker tracker) {
                System.out.println("------------------------ Заявки -------------------");
                for (Item item : tracker.findAll()) {
                    if (item != null) {
                        System.out.println(item.toString());
                    }
                }
            }

            /**
             * @return информация
             */
            @Override
            public String info() {
                return String.format("%s%s", this.key(), ". Показать все заявки");
            }
        }

    /**
     * @author Chashkov Alexander
     * @version 0.0.0.1
     * @since 2018.12.09
     * AddItem
     */
    private class UpdateItem implements UserAction {
        /**
         * @return ключ действия
         */
        @Override
        public int key() {
            return Actions.EDITED.ordinal();
        }

        /**
         * метод редактирования заявки
         *
         * @param input   приглашение для ввода
         * @param tracker tracker хранилище заявок
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("-------------Редактирование заявки -----------------");
            String id = input.ask("Введите идентификатор заявки: ");
            Item item = tracker.findById(id);
            if (item == null) {
                System.out.println("Заявка с таким идентификатором не найдена!");
            } else {
                if (item != null) {
                    System.out.println(item.toString());
                }
                item.setName(input.ask("Введите новое имя для заявки: "));
                item.setDesc(input.ask("Введите новое описание для заявки: "));
                item.setComments(new String[]{input.ask("Введите комментарии для заявки: ")});
                if (tracker.replace(id, item)) {
                    System.out.println("Заявка отредактирована.");
                } else {
                    System.out.println("Ошибка. Изменения не применены.");
                }
            }
        }

        /**
         * @return информация
         */
        @Override
        public String info() {
            return String.format("%s%s", this.key(), ". Редактировать заявку");
        }
    }

    private static class FindItemById implements UserAction {
        /**
         * @return ключ действия
         */
        @Override
        public int key() {
            return Actions.FIND_BY_ID.ordinal();
        }
        /**
         * метод поиска заявки по идентификатору
         * @param input приглашение для ввода
         * @param tracker tracker хранилище заявок
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("-------------Поиск заявки --------------------------");
            String id = input.ask("Введите идентификатор заявки: ");
            Item item = tracker.findById(id);
            if (item != null) {
                System.out.println(item.toString());
            } else {
                System.out.println("Заявка с индентификатором " + id + " не найдена!");
            }
        }
        /**
         * @return информация
         */
        @Override
        public String info() {
            return String.format("%s%s", this.key(), ". Найти заявку по идентификатору");
        }
    }

    private class FindItemsByName implements UserAction {
        /**
         * @return ключ действия
         */
        @Override
        public int key() {
            return Actions.FIND_BY_NAME.ordinal();
        }
        /**
         * метод поиска заявки по названию
         * @param input приглашение для ввода
         * @param tracker tracker хранилище заявок
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("-------------Поиск заявки --------------------------");
            String name = input.ask("Введите название заявки: ");
            Item[] items = tracker.findByName(name);
            if (items.length > 0) {
                System.out.println("-------------заявка -----------------------------");
                for (Item item : items) {
                    if (item != null) {
                        System.out.println(item.toString());
                    }
                }
            } else {
                System.out.println("Заявки с таким именем не найдены. ");
            }
        }
        /**
         * @return информация
         */
        @Override
        public String info() {
            return String.format("%s%s", this.key(), ". Найти заявку по названию");
        }
    }

    private class ExitProgram implements UserAction {

        /**
         * @return ключ действия
         */
        @Override
        public int key() {
            return Actions.EXIT.ordinal();
        }

        /**
         * метод выхода из программы
         * @param input приглашение для ввода
         * @param tracker tracker хранилище заявок
         */
        @Override
        public void execute(Input input, Tracker tracker) {
        }
        /**
         * @return информация
         */
        @Override
        public String info() {
            return String.format("%s%s", this.key(), ". Выйти из программы");
        }
    }
}

