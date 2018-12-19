package ru.job4j.search;

import java.util.LinkedList;
/**
 * class PriorityQueue
 * @author Alexander Chashkov
 * @version 0.0.0.1
 * @since 2018.12.19
 */
public class PriorityQueue {
    /**
     * список задач
     */
    private int indexUrgent = 0;
    private int indexMiddle = 0;

    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставки использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {
        if (task.getPriority() == 5) {
            tasks.add(tasks.size(), task);
        }
        if (task.getPriority() == 1) {
            tasks.add(indexUrgent++, task);
            indexMiddle++;
        }
        if (task.getPriority() == 3) {
            tasks.add(indexMiddle++, task);
        }
    }

    public Task take() {
        return this.tasks.poll();
    }
}
