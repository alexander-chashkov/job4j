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
    private ArrayList<Item> items = new ArrayList<>();

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
        this.items.add(item);
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
        for (Item itemTmp : this.items) {
            if (itemTmp.getId().equals(id)) {
                item.setId(itemTmp.getId());
                this.items.set(this.items.indexOf(itemTmp), item);
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * @return копия всех непустых заявок
     */
    public ArrayList<Item> findAll() {
        return this.items;
    }

    /**
     * @param key имя заявки для поиска
     * @return найденые заявки
     */
    public ArrayList<Item> findByName(String key) {
        ArrayList<Item> tmp = new ArrayList();
        int posit = 0;
        for (Item item : this.items) {
            if (item != null && item.getName().equals(key)) {
                tmp.add(item);
            }
        }
        return tmp;
    }

    /**
     * @param id идентификатор для удаления заявки
     * @return true - прошло удаление
     */
    public boolean delete(String id) {
        boolean result = false;
        for (Item item : this.items) {
            if (item.getId().equals(id)) {
                this.items.remove(this.items.indexOf(item));
                result = true;
                break;
            }
        }
        return result;
    }
}
