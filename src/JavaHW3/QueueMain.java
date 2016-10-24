package JavaHW3;

/**
 * Created by vrom911 on 10/24/16.
 */
public class QueueMain {
    public static void main(String[] args) {
        ArrayQueue aq = new ArrayQueue();
        add(aq, 20);
        del(aq, 10);
        show(aq);
        LinkedQueue lq = new LinkedQueue();
        add(lq, 20);
        del(lq, 10);
        show(lq);
    }

    private static void add(AbstractQueue q, int num) {
        for(int i = 0; i < num; i++) {
            q.enqueue(i);
        }
    }
    private static void del(AbstractQueue q, int num) {
        for(int i = 0; i < num; i++) {
            q.dequeue();
        }
    }
    private static void show(AbstractQueue q) {
        System.out.println(q);
    }

}
