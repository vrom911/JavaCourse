package intro.JavaHW3;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Predicate;


public class ArrayQueue extends AbstractQueue{
    private Object[] m = new Object[1];
    private int head;
    private int tail;

    public  ArrayQueue() {}

    public ArrayQueue(Object[] m) {
        this.m = m;
        this.head = 0;
        this.tail = this.size = m.length;
    }

    @Override
    public String toString() {
        return "ArrayQueue{ " +
                "m = " + Arrays.toString(m) + ", size = " + size() + ", head = " + head + ", tail = " + tail +
                '}';
    }

    public void enqueue(Object el) {
        checkAdd();
        m[tail] = el;
        tail = (tail + 1) % m.length;
        size++;
    }

    public Object elementSpec() {
        return m[head];
    }

    protected Object dequeueSpec() {
        Object h = m[head];
        m[head] = null;
        head = (head + 1) % m.length;
        size--;
        checkDel();
        return h;
    }

    public void clear() {
        m = new Object[1];
        head = tail = size = 0;
    }

    public void push(Object el) {
        checkAdd();
        head = (m.length + head - 1) % m.length;
        m[head] = el;
        size++;
    }

    public Object peekSpec() {
        return m[(m.length + tail - 1) % m.length];
    }

    protected Object removeSpec() {
        int idx = (m.length + tail - 1) % m.length;
        Object h = m[idx];
        m[idx] = null;
        tail = idx;
        size--;
        checkDel();
        return h;
    }

    private void checkAdd() {
        if (size() + 1 > m.length) {
            changeArray(m.length * 2);
        }
    }

    private void checkDel() {
        if (size() * 2 <= m.length) {
            changeArray(size());
        }
    }

    private void changeArray(int newLen) {
        m = createNewArray(newLen);
        head = 0;
        tail = size();
    }

    public Queue filter(Predicate<Object> pr) {
        return createNewArrayQueue(pr, x -> x);
    }

    public Queue map(Function<Object, Object> f) {
        return createNewArrayQueue( x -> true, f);
    }

    public Queue createNewArrayQueue(Predicate<Object> pr, Function<Object, Object> f) {
        ArrayQueue newA = new ArrayQueue();
        for(int i = 0; i < size(); i++) {
            if (pr.test(m[(head + i) % m.length])) {
                newA.enqueue(f.apply(m[(head + i) % m.length]));
            }
        }
        return newA;
    }

    private Object[] createNewArray(int newLen) {
        Object[] newM = new Object[newLen];
        for(int i = 0; i < size; i++) {
            newM[i] = m[(head + i) % m.length];
        }
        return newM;
//        return createArrayQueue(x -> true, x -> x).m;
    }

}