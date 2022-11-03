import java.util.Arrays;
import java.util.Objects;

/**
 * 最大重复子字符串
 * @since v0.0.0
 * @since 2022/11/3
 */
public class Solution1668 {

    public int maxRepeating(String sequence, String word) {
        int n = sequence.length(), m = word.length(), ans = 0;
        int[] f = new int[n + 10];
        for (int i = 1; i <= n; i++) {
            if (i - m < 0) continue;
            if (sequence.substring(i - m, i).equals(word)) f[i] = f[i - m] + 1;
            ans = Math.max(ans, f[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution1668 solution1668 = new Solution1668();
        System.out.println(solution1668.maxRepeating("aaabaaaabaaabaaaabaaaabaaaabaaaaba", "aaaba"));
    }

}
