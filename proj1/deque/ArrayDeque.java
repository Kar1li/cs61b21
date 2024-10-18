package deque;



public class ArrayDeque<T> implements Deque<T> {

    private int initialSize = 8;

    public class ArrayStack<T> {

        private int bottom;
        private int top;
        private T[] core;

        public ArrayStack() {
            core = (T[]) new Object[initialSize/2];
            top = -1;
            bottom = 0;
        }

        public void resize(int len) {
            T[] newCore = (T[]) new Object[len];
            for (int i = bottom; i <= top; ++i) {
                newCore[i-bottom] = core[i];
            }
            top = semiSize() - 1;
            bottom = 0;
            core = newCore;
        }

        public void add(T item) {
            if (top + 1 == core.length) {
                resize(2 * core.length );
            }
            ++top;
            core[top] = item;
        }

        public T remove() {
            T toReturn = core[top];
            --top;
            if (core.length >= initialSize && 4 * (top - bottom + 1) < core.length) {
                resize(2 * (top - bottom + 1));
            }
            return toReturn;
        }

        public T dequeue() {
            T toRet = core[bottom];
            ++bottom;
            if (core.length >= initialSize && 4 * (top - bottom + 1) < core.length) {
                resize(2 * (top - bottom + 1));
            }
            return toRet;

        }

        public T get(int i) {return core[i + bottom];}
        public int semiSize() {return top - bottom + 1;}

        public void printHead() {
            for (int i = top; i >= bottom; --i) {
                System.out.print(core[i] + " ");
            }
        }

        public void printTail() {
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





}