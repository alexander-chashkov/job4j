package tracker;

import java.time.Instant;
import java.util.Arrays;
/**
 *  @version 0.0.0.1
 *  @since 2018.12.02
 *  @author Chashkov Alexander
 *  класс для хранения данных о заявке
 */
public class Item {
    private String id;
    /**
     *  название заявки
     */
    private String name;
    /**
     * описание заявки
     */
    private String desc;
    /**
     * дата создания в мс
     */
    private long created;
    /**
     * комментарии
     */
    private String[] comments;

    /**
     * @param name название заявки
     * @param desc описание заявки
     * @param created дата создания в мс
     * @param comments комментарии
     */
    public Item(String name, String desc, long created, String[] comments) {
        this.name = name;
        this.desc = desc;
        this.created = created;
        this.comments = comments;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public long getCreated() {
        return this.created;
    }

    public void setComments(String[] comments) {
        this.comments = comments;
    }

    public String[] getComments(){
        return this.comments;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        Instant instant = Instant.ofEpochMilli(this.getCreated());
        return "------------------------ Заявка -------------------\n" +
        "------------------------ Идентификатор : " + this.getId() + "\n" +
        "Название : " + this.getName() + "\n" +
        "Описание : " + this.getDesc() + "\n" +
        "Дата и время создания: " + instant.toString() + "\n" +
        "Комментарии : " + Arrays.toString(this.getComments()) + "\n" +
        "---------------------------------------------------";
    }
}
