package ru.job4j.search;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PriorityQueueTest {
    /**
     * poll high
     */
    @Test
    public void whenHigherPriority() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("middle1", 3));
        queue.put(new Task("middle2", 3));
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle3", 3));
        queue.put(new Task("urgent1", 1));
        queue.put(new Task("urgent2", 1));
        queue.put(new Task("low2", 5));
        queue.put(new Task("low3", 5));
        Task result = queue.take();
        assertThat(result.getDesc(), is("urgent"));
    }

    /**
     * poll high middle1
     */
    @Test
    public void whenHigherPriorityThenMiddle1() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("middle1", 3));
        queue.put(new Task("middle2", 3));
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle3", 3));
        queue.put(new Task("low2", 5));
        queue.put(new Task("low3", 5));
        queue.take();
        Task result = queue.take();
        assertThat(result.getDesc(), is("middle1"));
    }
}
