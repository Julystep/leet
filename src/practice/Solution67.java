/**
 * 二进制求和
 *
 * @since 2022/11/22
 */
public class Solution67 {

    public String addBinary(String a, String b) {
        int m = a.length(), n = b.length();
        int len = m > n ? m + 1 : n + 1;
        int[] ans = new int[len];
        for (int i = len - 1, j = m - 1, k = n - 1; i >= 0; i--, j--,k--) {
            int x = 0, y = 0;
            if (j >= 0) x = a.charAt(j) - '0';
            if (k >= 0) y = b.charAt(k) - '0';
            ans[i] = x + y;
        }
        for (int i = len -1; i > 0; i--) {
            ans[i - 1] += ans[i]/2;
            ans[i] %= 2;
        }
        int start = ans[0] == 1 ? 0 : 1;
        String result = "";
        for (int i = start; i < len; i++) {
            result += ans[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Solution67 solution67 = new Solution67();
        solution67.addBinary("11", "1");
    }

}
