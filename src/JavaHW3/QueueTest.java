package JavaHW3;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by vrom911 on 10/25/16.
 */
public class QueueTest {
    private Object[] testArrayQueue = new Object[0];
    /** ArrayQueue Tests */
    @Test
    public void testArrayQueueElement() throws Exception {
        ArrayQueue aq = new ArrayQueue();
        aq.enqueue("a");
        Object el = aq.element();
        assertEquals("a", el);
    }
    @Test
    public void testArrayQueueDequeueEmpty() throws Exception {
        ArrayQueue aq = new ArrayQueue();
        Object el = aq.dequeue();
        assertEquals(null, el);
    }
    @Test
    public void testArrayQueueDequeueElement() throws Exception {
        ArrayQueue aq = new ArrayQueue();
        add(aq, 20);
        Object el = aq.dequeue();
        assertEquals(0, el);
    }
    @Test
    public void testArrayQueueSize() throws Exception {
        ArrayQueue aq = new ArrayQueue();
        add(aq, 20);
        Object s = aq.size();
        assertEquals(20, s);
    }

    /** LinkedQueue Tests */
    @Test
    public void testLinkedQueueDequeueEmpty() throws Exception {
        LinkedQueue lq = new LinkedQueue();
        Object el = lq.dequeue();
        assertEquals(null, el);
    }
    @Test
    public void testLinkedQueueDequeueElement() throws Exception {
        LinkedQueue lq = new LinkedQueue();
        add(lq, 20);
        Object el = lq.dequeue();
        assertEquals(0, el);
    }

    private static void add(AbstractQueue q, int num) {
        for(int i = 0; i < num; i++) {
            q.enqueue(i);
        }
    }
    private static void del(AbstractQueue q, int num) {
        for(int i = 0; i < num; i++) {
            q.dequeue();
        }
    }
    private static void show(AbstractQueue q) {
        System.out.println(q);
    }


}