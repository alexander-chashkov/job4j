package tracker;
import java.util.*;
/**
 *  @version 0.0.0.1
 *  @since 2018.12.02
 *  @author Chashkov Alexander
 *  класс обертка для заявок
 */
public class Tracker {
    private static final Random RN = new Random();
    /**
     * Заявки
     */
    private Item[] items = new Item[100];
    /**
     * позиция по заявкам
     */
    private int position = 0;

    /**
     * @return  идентификатор
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt(100));
    }

    /**
     * @param item заявка для добавления
     * @return заявка добавленная
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[position++] = item;
        return item;
    }

    /**
     * @param id идентификатор заявки для поиска
     * @return найденая заявка
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : this.items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    /**
     * @param id идентификатор заявки для замены
     * @param item заявка для замены
     * @return true - прошла замена
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int i = 0; i < this.position; i++) {
            if (this.items[i].getId().equals(id)) {
                item.setId(this.items[i].getId());
                this.items[i] = item;
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * @return копия всех непустых заявок
     */
    public Item[] findAll() {
        return Arrays.copyOf(this.items, this.position);
    }

    /**
     * @param key имя заявки для поиска
     * @return найденые заявки
     */
    public Item[] findByName(String key) {
        Item[] tmp = new Item[100];
        int posit = 0;
        for (Item item : this.items) {
            if (item != null && item.getName().equals(key)) {
                tmp[posit++] = item;
            }
        }
        return Arrays.copyOf(tmp, posit);
    }

    /**
     * @param id идентификатор для удаления заявки
     * @return true - прошло удаление
     */
    public boolean delete(String id) {
        boolean result = false;
        for (int i = 0; i <= this.position; i++) {
            if (this.items[i].getId().equals(id)) {
                System.arraycopy(this.items, i + 1, this.items, i, this.position - i - 1);
                this.items[position] = null;
                position--;
                result = true;
                break;
            }
        }
        return result;
    }
}
