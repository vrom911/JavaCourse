package JavaHW3;

/**
 * Created by vrom911 on 10/24/16.
 */
public abstract class AbstractQueue implements Queue {
    protected int size;
    protected abstract Object dequeueSpec();
    protected abstract Object removeSpec();

    public Object dequeue() {
        return isEmpty() ? null : dequeueSpec();
    }
    public Object remove() {
        return isEmpty() ? null : removeSpec();
    }

    protected boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }
}
