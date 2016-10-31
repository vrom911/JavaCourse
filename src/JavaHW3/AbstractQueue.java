package JavaHW3;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by vrom911 on 10/24/16.
 */
public abstract class AbstractQueue implements Queue {
    protected int size;
    protected abstract Object dequeueSpec();
    protected abstract Object removeSpec();
    protected abstract Object elementSpec();
    protected abstract Object peekSpec();
    protected abstract Queue filterSpec(Predicate<Object> pr);
    protected abstract Queue mapSpec(Function<Object, Object> f);

    public Object dequeue() {
        return isEmpty() ? null : dequeueSpec();
    }

    public Object remove() {
        return isEmpty() ? null : removeSpec();
    }

    public Object element() {
        return isEmpty() ? null : elementSpec();
    }

    public Object peek() {
        return isEmpty() ? null : peekSpec();
    }

    public Queue filter(Predicate<Object> pr) {
        return isEmpty() ? null : filterSpec(pr);
    }

    public Queue map(Function<Object, Object> f) {
        return isEmpty() ? null : mapSpec(f);
    }

    protected boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}
