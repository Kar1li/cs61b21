package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {

    private ArrayDeque<T> deque;
    private Comparator<T> cpt;

    public MaxArrayDeque(Comparator<T> c) {
        super();
        deque = new ArrayDeque<>();
        cpt = c;
    }

    public T max() {
        if (deque.isEmpty()) return null;
        T required = deque.get(0);
        for (int i = 1; i < deque.size(); ++i) {
            if (cpt.compare(deque.get(i), required) > 0) required = deque.get(i);
        }

        return required;
    }

    public T max(Comparator<T> c) {
        if (deque.isEmpty()) return null;
        T required = deque.get(0);
        for (int i = 1; i < deque.size(); ++i) {
            if (c.compare(deque.get(i), required) > 0) required = deque.get(i);
        }
        return required;
    }





}
