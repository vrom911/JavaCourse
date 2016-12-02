package intro.JavaHW3;

import java.util.Arrays;

public class ArrayQueueModule {

    private static Object[] m = new Object[1];
    private static int head;
    private static int tail;
    private static int size;

    @Override
    public String toString() {
        return "ArrayQueue{ " +
                "m = " + Arrays.toString(m) + ", size = " + size() + ", head = " + head + ", tail = " + tail +
                '}';
    }

    public static void enqueue(Object el) {
        checkAdd();
        m[tail] = el;
        tail = (tail + 1) % m.length;
        size++;
//        System.out.println(size() + "++" + m.length);
    }

    public static Object element() {
        return m[head];
    }
    public static Object dequeue() {
        return isEmpty() ? null : dequeueSpec();
    }
    protected static Object dequeueSpec() {
        Object h = m[head];
        m[head] = null;
        head = (head + 1) % m.length;
        size--;
        checkDel();
        return h;
    }
    public static void clear() {
        m = new Object[1];
        head = tail = size = 0;
    }
    public static int size() {
        return size;
    }
    public static boolean isEmpty() {
        return size == 0;
    }
    private static void checkAdd() {
        if (size() + 1 > m.length) {
            changeArray(m.length * 2);
        }
    }
    private static void checkDel() {
        if (size() * 2 <= m.length) {
            changeArray(size());
        }
    }
    private static Object[] createNewArray(int newLen) {
        Object[] newM = new Object[newLen];
        for(int i = 0; i < size; i++) {
            newM[i] = m[(head + i) % m.length];
        }
        return newM;
    }
    private static void changeArray(int newLen) {
        m = createNewArray(newLen);
        head = 0;
        tail = size();
    }
}
