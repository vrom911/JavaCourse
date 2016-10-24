package JavaHW3;

/**
 * Created by vrom911 on 10/24/16.
 */
public interface Queue {
    void enqueue(Object el);
    Object element();
    Object dequeue();
    int size();
    void clear();
}
