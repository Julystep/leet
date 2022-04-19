package practice;

import java.util.Arrays;

/**
 * 两次遍历
 * 问题拆解
 */
public class Solution821 {

    public int[] shortestToChar(String s, char c) {
        int[] ans = new int[s.length()];
        Arrays.fill(ans, Integer.MAX_VALUE);
        int flag = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) flag = i;
            if (flag != -1) ans[i] = Math.min(ans[i], i - flag);
        }
        flag = -1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == c) flag = i;
            if (flag != -1) ans[i] = Math.min(ans[i], flag - i);
        }
        return ans;
    }

}
