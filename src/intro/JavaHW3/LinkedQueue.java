package intro.JavaHW3;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Predicate;

public class LinkedQueue extends AbstractQueue{
    private static Node head;
    private static Node tail;

    private class Node {
        private Object val;
        private Node next;

        private Node(Object val, Node next) {
            this.next = next;
            this.val = val;
        }
    }

    @Override
    public String toString() {
        return "LinkedQueue{" +
                "m = " + Arrays.toString(getArray()) +
                ", head = " + head.val +
                ", tail = " + tail.val +
                ", size = " + size +
                '}';
    }

    public void enqueue(Object val) {
        Node newTail = new Node(val, null);
        if (isEmpty()) {
            head = tail = newTail;
        } else {
            tail.next = newTail;
            tail = tail.next;
        }
        size++;
    }

    public Node elementSpec() {
        return head;
    }

    protected Object dequeueSpec() {
        Object el = head.val;
        head = head.next;
        size--;
        if (isEmpty()) {
            tail = null;
        }
        return el;
    }
    public void clear() {
        size = 0;
        head = tail = null;
    }

    public void push(Object el) {
        Node newHead = new Node(el, null);
        if (isEmpty()) {
            head = tail = newHead;
        } else {
            newHead.next = head;
            head = newHead;
        }
        size++;
    }

    protected Object peekSpec() {
        return tail.val;
    }

    protected Object removeSpec() {
        Node el = head;
        for(int i = 0; i < size; i++, el = el.next) {
            if (el.next.equals(tail)) {
                el.next = null;
                tail = el;
                size--;
                break;
            }
        }
        if (isEmpty()) {
            head = null;
        }
        return el;
    }

    public Queue filter(Predicate<Object> pr) {
        return createNewLinkedQueue(pr, x -> x);
    }

    public Queue map(Function<Object, Object> f) {
        return createNewLinkedQueue(x -> true, f);
    }

    public Queue createNewLinkedQueue(Predicate<Object> pr, Function<Object, Object> f) {
        LinkedQueue newA = new LinkedQueue();
        for(Node el = head; el != null; el = el.next) {
            if (pr.test(el.val)) {
                newA.enqueue(f.apply(el.val));
            }
        }
        return newA;
    }

    public Object[] getArray() {
        Object[] ar = new Object[size];
        Node el = head;
        for(int i = 0; i < size; i++) {
            ar[i] = el.val;
            el = el.next;
        }
        return ar;
    }

}