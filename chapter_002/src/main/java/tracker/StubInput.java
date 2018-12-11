package tracker;

/**
 *  @version 0.0.0.1
 *  @since 2018.12.04
 *  @author Chashkov Alexander
 *  StubInput
 */
public class StubInput implements Input {
    private String[] answers;
    private int position;

    public StubInput(String[] answers) {
        this.answers = answers;
    }

    /**
     * @param question  запрос
     * @return введенные данные
     */
    public String ask(String question) {
        return answers[this.position++];
    }

    /**
     * @param question запрос, приглашение на ввод данных
     * @return введеные данные
     */
    public int ask(String question, int[] range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return key;
        } else {
            throw new MenuOutException("Команда вне диапазона меню! ");
        }
    }
}
