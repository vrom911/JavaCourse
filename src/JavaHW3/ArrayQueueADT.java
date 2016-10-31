package JavaHW3;

/**
 * Created by vrom911 on 10/26/16.
 */
public class ArrayQueueADT {
    private Object[] m = new Object[1];
    private int head;
    private int tail;
    private int size;

    public static void enqueue(ArrayQueueADT queue, Object el) {
        checkAdd(queue);
        queue.m[queue.tail] = el;
        queue.tail = (queue.tail + 1) % queue.m.length;
        queue.size++;
    }

    public static Object element(ArrayQueueADT queue) {
        return queue.m[queue.head];
    }

    public static Object dequeue(ArrayQueueADT queue) {
        return isEmpty(queue) ? null : dequeueSpec(queue);
    }

    protected static Object dequeueSpec(ArrayQueueADT queue) {
        Object h = queue.m[queue.head];
        queue.m[queue.head] = null;
        queue.head = (queue.head + 1) % queue.m.length;
        queue.size--;
        checkDel(queue);
        return h;
    }

    public static void clear(ArrayQueueADT queue) {
        queue.m = new Object[1];
        queue.head = queue.tail = queue.size = 0;
    }

    public static int size(ArrayQueueADT queue) {
        return queue.size;
    }

    public static boolean isEmpty(ArrayQueueADT queue) {
        return queue.size == 0;
    }

    private static void checkAdd(ArrayQueueADT queue) {
        if (size(queue) + 1 > queue.m.length) {
            changeArray(queue, queue.m.length * 2);
        }
    }

    private static void checkDel(ArrayQueueADT queue) {
        if (size(queue) * 2 <= queue.m.length) {
            changeArray(queue, size(queue));
        }
    }

    private static Object[] createNewArray(ArrayQueueADT queue, int newLen) {
        Object[] newM = new Object[newLen];
        for(int i = 0; i < queue.size; i++) {
            newM[i] = queue.m[(queue.head + i) % queue.m.length];
        }
        return newM;
    }

    private static void changeArray(ArrayQueueADT queue, int newLen) {
        queue.m = createNewArray(queue, newLen);
        queue.head = 0;
        queue.tail = size(queue);
    }
}
