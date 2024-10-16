package deque;



public class ArrayDeque<T> {

    private int initialSize = 8;

    public class ArrayStack<T> {

        private int top;
        private T[] core;

        public ArrayStack() {
            core = (T[]) new Object[initialSize/2];
            top = -1;
        }

        public void resize(int len) {
            T[] newCore = (T[]) new Object[len];
            for (int i = 0; i <= top; ++i) {
                newCore[i] = core[i];
            }
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
            if (core.length >= initialSize && 4 * (top + 1) < core.length) {
                resize(2 * (top + 1));
            }
            return toReturn;
        }

        public T get(int i) { return core[i];}
        public int semiSize() {return top + 1;}

        public void printStack() {
            for (int i = 0; i <= top; ++i) {
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


    public boolean isEmpty(){
        return size == 0;
    }

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
        --size;
        return toHead.remove();
    }

    public T removeLast() {
        --size;
        return toTail.remove();
    }

    public T get(int index) {
        if (index < 0 || index >= size) return null;
        if (index < toHead.semiSize()) {
            return toHead.get(index);
        } else {
            return toTail.get(index - toHead.semiSize());
        }

    }

    public void printDeque() {
        toHead.printStack(); toTail.printStack();
        System.out.print("\n");
    }





}