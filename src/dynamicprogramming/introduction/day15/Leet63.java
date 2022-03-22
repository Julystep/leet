package dynamicprogramming.introduction.day15;

// 63 不同路径2
// 我的思路：与 不同路径 解法相同，仅仅是多加了几层判断。
// 滚动数组：本题的每个解法都不存在后效性，所以可以将数据降成一维，每次仅存储一排的情况。
public class Leet63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        dp[0][0] = 1;
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }
                if (i == 0 && j != 0) dp[i][j] = dp[i][j-1];
                else if (i != 0 && j == 0) dp[i][j] = dp[i-1][j];
                else if (i == 0) {
                }
                else dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }

    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[] f = new int[m];

        f[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (obstacleGrid[i][j] == 1) {
                    f[j] = 0;
                    continue;
                }
                if (j - 1 >= 0 && obstacleGrid[i][j - 1] == 0) {
                    f[j] += f[j - 1];
                }
            }
        }

        return f[m - 1];
    }

}
