package tracker;
/**
 *  @version 0.0.0.1
 *  @since 2018.12.10
 *  @author Chashkov Alexander
 *  public class ValidateInput extends ConsoleInput {
 */
public class ValidateInput extends ConsoleInput {
    /**
     * @param question запрос, приглашение на ввод данных
     * @return введеные данные
     */
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int result = -1;
        do {
            try {
                result = super.ask(question, range);
                invalid = false;
            } catch (NumberFormatException nfe) {
                System.out.println("Ошибка. Введите верные данные!");
            } catch (MenuOutException moe) {
                System.out.println("Введите команду из диапазона меню");
            }
        } while (invalid);
        return result;
    }
}
