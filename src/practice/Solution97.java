package practice;

/**
 * 动态规划
 * 大问题拆成了小问题：i长度的s1 与 j 长度的s2 是否能匹配 i + j 长度的s3
 *
 * 创建二维数组dp，当s1、s2字符串长度为0时，直接默认为true。
 * 当长度不为0时判断当前字符是否与s3对应位置上的字符长度一致，一致就设置当前位置
 * 为true，否则为false。如此直到最大值。
 */

public class Solution97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length(), m = s2.length(), t = s3.length();
        if (n + m != t) {
            return false;
        }
        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][0] = true;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                int p = i + j - 1;
                if (i > 0) {
                    dp[i][j] = dp[i][j] || (dp[i-1][j] && s1.charAt(i-1) == s3.charAt(p));
                }
                if (j > 0) {
                    dp[i][j] = dp[i][j] || (dp[i][j-1] && s2.charAt(j-1) == s3.charAt(p));
                }
            }
        }
        return dp[n][m];
    }
}
