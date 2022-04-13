package practice;

/**
 * 回文字串核心思想，如果 字符串是一个回文字串，那么当他左右两边的字符相同时，他依然是个回文字串。
 * dp模拟的是第i个字符串到第j个字符串
 * 子问题为第i+1到j-1的字符串是否为回文子字符串
 * 特殊情况为 i、j相邻，i=j。
 */

public class Solution5 {
    public String longestPalindrome(String s) {
        // 用来记录最长回文字串的开头与结尾
        int left = 0, right = 0;
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int l = 2; l <= len; l++) {
            for (int i = 0; i < len; i++) {
                int j = l + i - 1;
                if (j >= len) {
                    break;
                }
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                    if (dp[i][j] && j - i > right - left) {
                        left = i;
                        right = j;
                    }
                }
            }
        }
        return s.substring(left, right + 1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution5().longestPalindrome("aaaaa"));
    }
}
