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
        boolean result = true;
        if (data.length > 1) {
            for (int i = 0; i <= data.length / 2; i++) {
                if (data[i] != data[i + 1]) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }
}
