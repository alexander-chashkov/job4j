package ru.job4j.array;

/**
 * Обертка над строкой.
 *  @version 0.0.0.1
 *  @author Chashkov Alexander
 *  @since 2018.11.24
 */
public class ArrayChar {
    private char[] data;

    public ArrayChar(String line) {
        this.data = line.toCharArray();
    }

    /**
     * Проверяет. что слово начинается с префикса.
     *
     * @param prefix префикс.
     * @return если слово начинается с префикса
     */
    public boolean startWith(String prefix) {
        char[] value = prefix.toCharArray();
        boolean result = this.data.length >= value.length;
        if (result) {
            for (int i = 0; i < value.length; i++) {
                result = (value[i] == this.data[i]);
                if (!result) {
                    return result;
                }
            }
        } else {
            return result;
        }
        return result;
    }

}

