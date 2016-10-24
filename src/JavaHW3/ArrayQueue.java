package JavaHW3;

import java.util.Arrays;

/**
 * Created by vrom911 on 10/23/16.
 */
public class ArrayQueue extends AbstractQueue{
    private Object[] m = new Object[1];
    private int head;
    private int tail;


    public int getSize() {
        return this.m.length;
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
//        System.out.println(size() + "++" + m.length);
    }
    public Object element() {
        return m[head];
    }
    public Object dequeueSpec() {
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

    private void checkAdd() {
        if (size() + 1 > m.length) {
            changeArray(m.length * 2);
        }
    }
    private void checkDel() {
        if (size()*2 <= m.length) {
            changeArray(size());
        }
    }
    private Object[] createNewArray(int newLen) {
        Object[] newM = new Object[newLen];
        for(int i = 0; i < size; i++) {
            newM[i] = m[(head + i) % m.length];
        }
        return newM;
    }
    private void changeArray(int newLen) {
        m = createNewArray(newLen);
        head = 0;
        tail = size();
    }
}