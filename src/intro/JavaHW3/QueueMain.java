package intro.JavaHW3;

public class QueueMain {
    public static void main(String[] args) {
        ArrayQueue aq = new ArrayQueue();
        aq.remove();
        aq.dequeue();
        add(aq, 20);
        for(int i = 0; i < 30; i++) {
            aq.push(i + 100);
        }
        show(aq);
        for(int i = 0; i < 15; i++) {
            System.out.println(aq.peek());
            aq.remove();
        }
        show(aq);
        add(aq, 20);
        show(aq);
        del(aq, 10);
        show(aq);
//        LinkedQueue lq = new LinkedQueue();
//        add(lq, 20);
//        for(int i = 0; i < 30; i++) {
//            lq.push(i + 100);
//        }
//        show(lq);
//        for(int i = 0; i < 15; i++) {
//            System.out.println(lq.peek());
//            lq.remove();
//        }
//        show(lq);
//        del(lq, 10);
//        show(lq);
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
