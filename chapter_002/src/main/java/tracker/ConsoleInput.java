package tracker;

import java.util.Scanner;

/**
 *  @version 0.0.0.1
 *  @since 2018.12.03
 *  @author Chashkov Alexander
 *  ConcoleInput
 */
public class ConsoleInput {
    public String ask(String question) {
        System.out.println(question);
        Scanner in = new Scanner(System.in);
        return in.next();
    }

}
