package dynamicprogramming.introduction.day15;

// 62 不同路径
// 使用二维数据，不断dp出最终结果。
public class Leet62 {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }


    public int uniquePaths1(int m, int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j ++) {
                if (j - 1 >= 0) {
                    dp[j] += dp[j-1];
                }
            }
        }
        return dp[n-1];
    }

}
