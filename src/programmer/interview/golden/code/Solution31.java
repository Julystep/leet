package programmer.interview.golden.code;

/**
 * 三步问题
 */
public class Solution31 {

    public int waysToStep(int n) {

        if (n <= 2) {
            return n;
        }
        if (n == 3) return 4;
        int x = 1, y = 2, z = 4;
        for (int i = 4; i < n+1; i++) {
            int temp = (x + y + z) % 1000000007;

            x = y;
            y = z;
            z = temp;
        }
        return z;
    }

}
