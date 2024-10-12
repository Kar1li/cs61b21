package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE

    @Test
    public void testThree()
    {
        AListNoResizing<Integer> a = new AListNoResizing<>();
        BuggyAList<Integer> b = new BuggyAList<>();
        for (int i = 4; i <= 6; ++i)
        {
            a.addLast(i); b.addLast(i);
        }

        assertEquals(a.size(),b.size());

        for (int i = 0; i < 3; ++i)
        {
            assertEquals(a.removeLast(), b.removeLast());
        }

    }


    @Test
    public void randomizedTest()
    {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> B = new BuggyAList<>();
        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                B.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");

            } else if (operationNumber == 1) {
                // size
                int size = L.size(), sz = B.size();
                System.out.println("size: A - " + size + " | B - " + sz);
                assertEquals(size, sz);
            } else if (operationNumber == 2){
                // getLast
                if (L.size()>0 && B.size() > 0)
                {
                    int lst = L.getLast();
                    int Lt = B.getLast();
                    System.out.println("getLast( " + lst + " | " + Lt + " )");
                    assertEquals(lst, Lt);
                }
            } else if (operationNumber == 3)
            {
                //removeLast
                if (L.size() > 0 && B.size() > 0)
                {
                    int lst = L.removeLast();
                    int Lt = B.removeLast();
                    System.out.println("removeLast( " + lst + " | " + Lt + " )");
                    assertEquals(lst, Lt);
                }
            }
        }
    }
}


