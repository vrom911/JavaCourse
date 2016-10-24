package JavaHW3;

/**
 * Created by vrom911 on 10/24/16.
 */
public abstract class AbstractQueue implements Queue {
    protected int size;
    public abstract Object dequeueSpec();


    public Object dequeue() {
        if (isEmpty()) {
            return null;
        }
        return dequeueSpec();
    }

    protected boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }

}
