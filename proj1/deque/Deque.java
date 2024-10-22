package deque;

public interface Deque<T> extends Iterable<T>  {

    public int size();

    public void addFirst(T item);

    public void addLast(T item);

    public void printDeque();

    public T removeFirst();

    public T removeLast();

    public T get(int index);

    //public boolean hasNext();

    //public T next();


    public default boolean isEmpty() {
        return size() == 0;
    }

}
