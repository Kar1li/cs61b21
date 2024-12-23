package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T>, Iterable<T> {

    private static class node<T> {
        public node<T> pv;
        public node<T> nx;
        public T val;
        public node(node<T> prev, T value, node<T> next) {
            pv = prev;
            val = value;
            nx = next;
        }
    }

    private int size;
    private node<T> sentinel;


    public LinkedListDeque() {
        size = 0;
        sentinel = new node<>(null, null, null);
        sentinel.pv = sentinel;
        sentinel.nx = sentinel;
        getRecursive_Node = sentinel;
    }

//    public boolean isEmpty(){
//        return size == 0;
//    }

    public void addFirst(T item) {
        node<T> newNode = new node<>(sentinel, item, sentinel.nx);
        sentinel.nx = newNode;
        newNode.nx.pv = newNode;
        ++size;
    }

    public T removeFirst() {
        if (size == 0) return null;
        T toReturn = sentinel.nx.val;
        sentinel.nx = sentinel.nx.nx;
        sentinel.nx.pv = sentinel;
        --size;
        return toReturn;
    }

    public void addLast(T item) {
        node<T> newNd = new node<>(sentinel.pv, item, sentinel);
        sentinel.pv = newNd;
        newNd.pv.nx = newNd;
        ++size;
    }

    public T removeLast() {
        if (size == 0) return null;
        T toReturn = sentinel.pv.val;
        sentinel.pv = sentinel.pv.pv;
        sentinel.pv.nx = sentinel;
        --size;
        return toReturn;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (node<T> i = sentinel.nx; i != sentinel; i = i.nx) {
            System.out.print(i.val + " ");
        }
        System.out.print("\n");
    }

    public T get(int i) {
        if (i >= size) return null;
        node<T> j = sentinel;
        while (i >= 0) {
            j = j.nx;
            --i;
        }
        return j.val;
    }

    private node<T> getRecursive_Node;
    public T getRecursive(int i) {
        if (i >= size) return null;
        if (i < 0) {
            T toRet = getRecursive_Node.val;
            getRecursive_Node = sentinel;
            return toRet;
        }
        getRecursive_Node = getRecursive_Node.nx;
        return getRecursive(i - 1);
    }

    private class LDIterator<T> implements Iterator<T> {

        private int curr;
        private T val;

        public LDIterator() {
            curr = 0; val = null;
        }

        @Override
        public boolean hasNext() {
            return curr < size;
        }

        @Override
        public T next() {
            T toR = (T) get(curr);
            ++curr;
            return toR;
        }
    }

    @Override
    public boolean equals(Object n) {
        if (n == null) return false;
        if (this == n) return true;
        if (!(n instanceof Deque<?>) ) return false;
        Deque<T> N = (Deque<T>) n;
        if ( N.size() != this.size) return false;
        for (int i = 0; i < size; ++i) {
            if (!this.get(i).equals(   N.get(i)  )) return false;
        }
        return true;

    }

    public Iterator<T> iterator() {
        return new LDIterator<>();
    }


}
