package dynamicprogramming.introduction.day21;


public class Leet279 {

    // 输入：n = 12
    // 输出：3
    // 解释：12 = 4 + 4 + 4


    // 2 => 2;
    // 3 => 1, 2
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        for (int i = 1; i <= n; i++) {
            int minn = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                minn = Math.min(minn, dp[i - j * j]);
            }
            dp[i] = minn + 1;
        }
        return dp[n];
    }

}
