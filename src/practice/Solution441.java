package practice;

/**
 * 本题可以采用2分
 * 利用等差公式 n(n+1)/2
 */

public class Solution441 {

    public int arrangeCoins(int n) {
        int l = 1, r = n;
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            if (((long) mid * (mid + 1)) <= (long) 2 * n) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

}
