
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
        System.out.println("testing");

        for (int i = 1; i < 10; ++i)
        {
            System.out.println(fib(i, 1, 0, 1));
        }



    }
}