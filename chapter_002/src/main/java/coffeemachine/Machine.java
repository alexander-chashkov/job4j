package coffeemachine;

/**
 * @author Chashkov Alexander
 * @version 0.0.0.1
 * @since 2018.12.17
 * Machine
 */
public class Machine {
    private int[] monets = {10, 5, 2, 1};

    public Machine() {
    }

    public Machine(int[] monets) {
        this.monets = monets;
    }

    /**
     * @param value колво денег
     * @param price цена на кофе
     * @return массив монет для сдачи
     */
    public int[] changes(int value, int price) {
        int change = value - price;
        int[] counts = new int[this.monets.length];
        int[] result = null;
        int fullCount = 0;
        if (change > 0) {
            for (int i = 0; i < this.monets.length; i++) {
                counts[i] = change / this.monets[i];
                fullCount += counts[i];
                change -= counts[i] * this.monets[i];
            }
            result = new int[fullCount];
            int j = 0;
            for (int i = 0; i < this.monets.length; i++) {
                while (counts[i] > 0) {
                    result[j] = this.monets[i];
                    counts[i]--;
                    j++;
                }
            }
        }
        return result;
    }
}
