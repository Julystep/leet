package practice;

/**
 * 二分查找
 * 注意对边界情况的讨论
 */
public class Solution69 {

    public int mySqrt(int x) {
        if (x == 0 || x == 1) return 0;
        int l = 0, r = x;
        while (l < r) {
            int mid = l + (r - l) / 2;
            long ans = (long) mid * mid;
            if (ans > x) r = mid;
            if (ans == x) return mid;
            if (ans < x) l = mid + 1;
        }
        return l - 1;
    }

}
