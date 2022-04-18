package practice;

/**
 * 动态规划
 * 二叉搜索树左子树不为空，中序查找会有顺序
 */

public class Solution96 {

    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1; dp[0] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }

}
