
package test;

import java.util.PrimitiveIterator;

public class test
{

    public static int fib(int n, int k, int f0, int f1)
    {
        if (n == 1) return f0;
        else if (n == 2) return f1;
        else if (n == 3) return k;
        else
        {
            return fib(n - 1, k + f1, f0, k);
        }
    }

    public static void main(String[] args)
    {
//        System.out.println("testing");
//
//        staqueue Q = new staqueue();
//
//        Q.enqueue(1); Q.enqueue(2); Q.enqueue(3); Q.printQ();
//
//        Q.dequeue(); Q.printQ();
//
//        Q.enqueue(4); Q.enqueue(5); Q.printQ();

//        Linked_List ll = new Linked_List();
//
//        for (int i = 0; i < 9; ++i) { ll.insert(i); }
//
//        ll.mirror().printList();
//
//        ll.printList();

        System.out.println( Practice2.Q3("BBABAABABBA"));










    }
}