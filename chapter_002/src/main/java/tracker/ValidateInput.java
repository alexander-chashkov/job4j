package tracker;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.List;

/**
 *  @version 0.0.0.1
 *  @since 2018.12.10
 *  @author Chashkov Alexander
 *  public class ValidateInput extends ConsoleInput {
 */
public class ValidateInput implements  Input {
    /**
     * источник
     */
    private final Input input;

    private int[] range;

    public ValidateInput(final Input input) {
        this.input = input;
    }

    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }

    /**
     * @param key ключ меню
     * @return true - ключ валидный
     */
    private boolean checkKey(int key) {
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        return exist;
    }

    /**
     * @param key ключ меню
     * @return true - ключ валидный
     */
    private boolean isDigit(String key) {
        boolean result = true;
        try {
            Integer.parseInt(key);
        } catch (NumberFormatException e) {
            result = false;
        }
        return result;
    }

    /**
     * @param key ключ меню
     * @return true - проверки успешно пройдены
     */
    private boolean hasAccess(final int key) {
         this.validates.forEach(action -> action.accept(key));
         return true;
    }


    /**
     * список проверок на валидность
     */
    private final List<Consumer<Integer>> validates = Arrays.asList(
            key -> {
                if (!this.checkKey(key)) {
                    throw new MenuOutException("Команда вне диапазона меню! ");
                }
            }
    );


    /**
     * @param question запрос, приглашение на ввод данных
     * @return введеные данные
     */
    public int ask(String question, int[] range) {
        this.range = range;
        boolean invalid = true;
        int result = 0;
        do {
            try {
                result = this.input.ask(question, range);
                invalid = !this.hasAccess(result);
            } catch (NumberFormatException nfe) {
                System.out.println("Ошибка. Введите верные данные!");
            } catch (MenuOutException moe) {
                System.out.println("Введите команду из диапазона меню");
            }
        } while (invalid);
        return result;
    }
}
