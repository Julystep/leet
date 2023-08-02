package practice;


public class Solution172 {

    public int trailingZeroes(int n) {
        int ans = 0;
        for (int i = 5; i <= n; i += 5) {
            for (int x = i; x % 5 == 0; x /= 5) {
                ++ans;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution172 solution172 = new Solution172();
        solution172.trailingZeroes(18);
    }

}
