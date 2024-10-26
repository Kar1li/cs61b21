package deque;


import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T>, Iterable<T> {

    private int initialSize = 8;

    private class ArrayStack<T> {

        private int bottom;
        private int top;
        private T[] core;

        public ArrayStack() {
            core = (T[]) new Object[initialSize / 2];
            top = -1;
            bottom = -1;
        }

        public void resize(int len) {
            T[] newCore = (T[]) new Object[len];
            for (int i = bottom; i <= top; ++i) {
                newCore[ i - bottom ] = core[i];
            }
            top = semiSize() - 1;
            bottom = 0;
            core = newCore;
        }

        public void add(T item) {
            if (top + 1 == core.length) {
                resize(2 * core.length );
            }
            if (semiSize() == 0) ++bottom;
            ++top;
            core[top] = item;
        }

        public T remove() {
            T toReturn = core[top];
            --top; if (bottom > top) { bottom = -1; top = -1; }
            if (core.length >= initialSize && 4 * semiSize() < core.length) {
                resize(2 * semiSize());
            }

            return toReturn;
        }

        public T dequeue() {
            T toRet = core[bottom]; ++bottom;
            if (bottom > top) { bottom = -1; top = -1; }
            if (core.length >= initialSize && 4 * semiSize() < core.length) {
                resize(2 * semiSize());
            }
            return toRet;

        }

        public T get(int i) {return core[i + bottom];}
        public int semiSize() {if (bottom == -1) return 0; return top - bottom + 1;}

        public void printHead() {
            if (semiSize() == 0) return;
            for (int i = top; i >= bottom; --i) {
                System.out.print(core[i] + " ");
            }
        }

        public void printTail() {
            if (semiSize() == 0) return;
            for (int i = bottom; i <= top; ++i) {
                System.out.print(core[i] + " ");
            }
        }


    }

    private ArrayStack<T> toTail;
    private ArrayStack<T> toHead;
    private int size;

    public ArrayDeque() {
        toHead = new ArrayStack<>();
        toTail = new ArrayStack<>();
        size = 0;
    }


//    public boolean isEmpty(){
//        return size == 0;
//    }

    public int size() {
        return size;
    }

    public void addFirst(T toBeAdded) {
        toHead.add(toBeAdded);
        ++size;
    }

    public void addLast(T item) {
        toTail.add(item);
        ++size;
    }

    public T removeFirst() {
        if (size == 0) return null;
        --size;
        if (toHead.semiSize() > 0) return toHead.remove();
        return toTail.dequeue();
    }

    public T removeLast() {
        if (size == 0) return null;
        --size;
        if (toTail.semiSize() > 0) return toTail.remove();
        return toHead.dequeue();
    }

    public T get(int index) {
        if (index < 0 || index >= size) return null;
        if (index < toHead.semiSize()) {
            return toHead.get(toHead.semiSize() - index - 1);
        } else {
            return toTail.get(index - toHead.semiSize());
        }

    }

    public void printDeque() {
        toHead.printHead(); toTail.printTail();
        System.out.print("\n");
    }


    private class ADIterator<T> implements Iterator<T> {
        private int curr;
        private T val;

        public ADIterator() {
            curr = 0;
            val = null;
        }

        public T next() {
            T ret = (T) get(curr);
            ++curr;
            return ret;
        }

        public boolean hasNext() {
            return curr < size;
        }
    }

    public Iterator<T> iterator () {
        return new ADIterator<>();
    }

    @Override
    public boolean equals(Object n) {
        if (n == null) return false;
        if (this == n) return true;
        if (!(n instanceof Deque<?>)) return false;
        Deque<T> N = (Deque<T>) n;
        if (N.size() != this.size) return false;
        for (int i = 0; i < size; ++i) {
            if (!this.get(i).equals(N.get(i))) return false;
        }
        return true;

    }




}
