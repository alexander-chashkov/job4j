package ru.job4j.array;
/**
 * class Check
 * @version 0.0.0.1
 * @author Chashkov Alexander
 * @since 2018.11.24
 */
public class Check {
    /**
     * @param data input array
     * @return true is mono array else false
     */
    public boolean mono(boolean[] data) {
        boolean result = false;
        if (data.length > 1) {
            for (int i = 0; i <= data.length / 2; i++) {
                result = data[i] == data[i + 1];
                if (!result) {
                    return result;
                }
            }
        } else {
            return !result;
        }
        return result;
    }
}
