package test;

public class Practice2
{
    public static int Q3(String inp)
    {
        int max = 0, A_B = 0, sum = 0, lastZeroPoint = -1;

        for (int i = 0; i < inp.length(); ++i)
        {
            char c = inp.charAt(i);
            if (A_B == 0) {
                lastZeroPoint = i;
                if (c == 'B') {
                    max = Math.max(sum, max);
                    sum = 0;
                }

            }
            else if (c == 'B' && A_B > 0) { --A_B; ++sum; }
            else if (c == 'A') {  ++A_B; ++sum; }
        }

        return max;
    }

}
