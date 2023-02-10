package practice;

/**
 * 爬楼梯
 */
public class Solution70 {

    public int climbStairs(int n) {
        if (n == 0 || n == 1) return 1;

        int p = 1, q = 1, r = 2;
        for (int i = 2; i < n; i++) {
            r = p + q;
            p = q;
            q = r;
        }
        return r;
    }

}
