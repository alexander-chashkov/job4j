package tracker;

import java.util.Scanner;

/**
 *  @version 0.0.0.1
 *  @since 2018.12.03
 *  @author Chashkov Alexander
 *  ConcoleInput
 */
public class ConsoleInput implements Input {
    /**
     * scanner
     */
    private Scanner in = new Scanner(System.in);
    /**
     * @param question запрос, приглашение на ввод данных
     * @return введеные данные
     */
    public String ask(String question) {
        System.out.println(question);
        return this.in.next();
    }

}
