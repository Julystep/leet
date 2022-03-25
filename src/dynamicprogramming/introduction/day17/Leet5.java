package dynamicprogramming.introduction.day17;

// 本次采用动态规划，按长度和单词起始位置规划
public class Leet5 {

    //输入：s = "babad"
    //输出："bab"
    //解释："aba" 同样是符合题意的答案。

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        boolean[][] dp = new boolean[len][len];
        char[] charArray = s.toCharArray();
        int maxLen = 1, begin = 0;
        for (int i = 0; i < len; i ++) {
            dp[i][i] = true;
        }
        for (int l = 2; l <= len; l ++) {
            for (int i = 0; i < len; i++) {
                int j = l + i - 1;
                if (j >= len) {
                    break;
                }
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

}
