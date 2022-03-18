package dynamicprogramming.introduction.day11;

public class Leet264 {

    // 首先每个丑数都可被 2、 3 、5 整除，所以反推每个丑数是由2 、3、 5相乘得出
    // 本题动态规划的点为每次都用2、3、5相乘得出最小的丑数，依次递推知道最终结果


    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        int p = 1, q = 1, r = 1, i = 2;
        dp[1] = 1;
        while (i <= n) {
            int num1 = dp[p] * 2, num2 = dp[q] * 3, num3 = dp[r] * 5;
            dp[i] = Math.min(Math.min(num1, num2), num3);
            if (dp[i] == num1) {
                p++;
            }
            if (dp[i] == num2) {
                q++;
            }
            if (dp[i] == num3) {
                r++;
            }
            i++;
        }
        return dp[n];
    }

}
