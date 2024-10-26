package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {


    private Comparator<T> cpt;

    public MaxArrayDeque(Comparator<T> c) {
        super();
        cpt = c;
    }

    public T max() {
        if (this.isEmpty()) return null;
        T required = this.get(0);
        for (int i = 1; i < this.size(); ++i) {
            if (cpt.compare(this.get(i), required) > 0) required = this.get(i);
        }

        return required;
    }

    public T max(Comparator<T> c) {
        if (this.isEmpty()) return null;
        T required = this.get(0);
        for (int i = 1; i < this.size(); ++i) {
            if (c.compare(this.get(i), required) > 0) required = this.get(i);
        }
        return required;
    }





}
