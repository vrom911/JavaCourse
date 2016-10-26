package JavaHW3;

/**
 * Created by vrom911 on 10/24/16.
 */
public interface Queue {
    /** Add element to the tail of the Queue */
    void enqueue(Object el);
    /** @return the head element in the Queue */
    Object element();
    /** Removes and @return the head element of the Queue*/
    Object dequeue();
    /** @return number of elements in the Queue */
    int size();
    /** removes everything from the queue */
    void clear();
    /** Add element to the head of the Queue */
    void push(Object el);
    /** @return the tail element in the Queue */
    Object peek();
    /** Remove the tail element from the Queue */
    Object remove();
}
