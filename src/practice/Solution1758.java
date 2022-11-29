package practice;

/**
 * 如果第一位是0，那么奇数位都应该是0
 * 如果第一位是1，那么奇数位都应该是1
 */
public class Solution1758 {

    public int minOperations(String s) {
        return Math.min(getNum(s, 1), getNum(s, 0));
    }

    public int getNum(String s, int flag) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int x = s.charAt(i) - '0';
            if (i % 2 == 0 && x != flag || i % 2 != 0 && x == flag) {
                ans++;
            }
        }
        return ans;
    }

    /**
     * 设字符串长度为n，如果该一部分需要x步，另一部分就是n-x
     *
     */
    public int minOperations1(String s) {
        int n = s.length(), cnt = 0;
        for (int i = 0; i < n; i++) cnt += (s.charAt(i) - '0') ^ (i & 1);
        return Math.min(cnt, n - cnt);
    }





}
