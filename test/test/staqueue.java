package test;

public class staqueue {

    private final int MAX = 100;
    private int[] head; private int[] tail;
    private int first; private int last;

    private void swap() {
        int[] temp = head; head = tail; tail = temp;
        int t = first; first = last; last = t;
    }

    public staqueue() {
        head = new int[MAX]; first = 0;
        tail = new int[MAX]; last = 0;
    }

    public boolean isEmpty() {
        return first == 0 && last == 0;
    }

    public void enqueue(int val) {
        if (first == 0) head[first++] = val;
        else tail[last++] = val;
    }

    public int dequeue() {
        int result = head[--first];
        if (first == 0) {
            int k = last;
            for (int i = 0; i < k; ++i) {
                head[first++] = tail[--last];
            }

        }

        return result;
    }

    public void printQ() {
        System.out.print("head: ");
        for (int i = 0; i < first; ++i) System.out.print(head[i]);
        System.out.print("\n");

        System.out.print("tail: ");
        for (int i = 0; i < last; ++i) System.out.print(tail[i]);
        System.out.print("\n");
    }

}
