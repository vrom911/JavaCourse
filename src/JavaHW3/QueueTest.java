package JavaHW3;

import org.junit.Before;
import org.junit.Test;

import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.Assert.*;

/**
 * Created by vrom911 on 10/25/16.
 */
public class QueueTest {
    private ArrayQueue basicAq = new ArrayQueue();
    private LinkedQueue basicLq = new LinkedQueue();
    private final Predicate<Object> p = (Object o) -> (int) o <= 10;
    private final Function<Object, Object> f = (Object i) ->  (int) i * 11;

    @Before
    public void createTestBase() {
        add(basicAq, 30);
        add(basicLq, 30);
    }

    @Test
    public void testArrayQueuePredicate() throws Exception {
        ArrayQueue newAq = new ArrayQueue();
        ArrayQueue filteredAq = (ArrayQueue) newAq.filter(p);
    }

    @Test
    public void testArrayQueueFilterEmpty() throws Exception {
        assertTrue("Not Queue", basicAq instanceof ArrayQueue);
        ArrayQueue newAq = (ArrayQueue) basicAq.filter(p);
        assertEquals("Size of new arrayQueue is not equals expected one", newAq.size(), 11);
        add(newAq, 3);
        assertEquals("Adding after filtering not  working", newAq.size(), 14);
    }

    @Test
    public void testLinkedQueuePredicate() throws Exception {
        assertTrue("Not Queue", basicLq instanceof LinkedQueue);
        LinkedQueue newAq = (LinkedQueue) basicLq.filter(p);
        assertEquals("Size of new arrayQueue is not equals expected one", newAq.size(), 11);
        add(newAq, 4);
        assertEquals("Adding after filtering not  working", newAq.size(), 15);
    }

    @Test
    public void testArrayQueueFunction() throws Exception {
        ArrayQueue newAq = (ArrayQueue) basicAq.map(f);
        assertEquals("Size of new arrayQueue is not equals expected one", newAq.size(), 30);
        add(newAq, 4);
        assertEquals("Adding after filtering not  working", newAq.size(), 34);
    }

    @Test
    public void testLinkedQueueFunction() throws Exception {
        LinkedQueue newAq = (LinkedQueue) basicLq.map(f);
        assertEquals("Size of new arrayQueue is not equals expected one", newAq.size(), 30);
        add(newAq, 4);
        assertEquals("Adding after filtering not  working", newAq.size(), 34);
    }

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