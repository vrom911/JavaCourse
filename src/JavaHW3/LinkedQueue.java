package JavaHW3;

import java.util.Arrays;

/**
 * Created by vrom911 on 10/24/16.
 */
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
    public Node element() {
        return this.head;
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
    public Object peek() {
        return isEmpty() ? null : tail.val;
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