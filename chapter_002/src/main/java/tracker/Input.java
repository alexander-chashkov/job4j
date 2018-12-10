package tracker;

/**
 *  @version 0.0.0.1
 *  @since 2018.12.04
 *  @author Chashkov Alexander
 *  input
 */
public interface Input {
    String ask(String question);
    int ask(String question, int[] range) throws MenuOutException;
}
