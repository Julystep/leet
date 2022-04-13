package practice;

public class Solution367 {

    public boolean isPerfectSquare(int num) {
        int l = 1, r = num / 2;
        while (l < r) {
            int mid = l + (r - l) / 2;
            long ans = (long) mid * mid;
            if (ans < num) l = mid + 1;
            if (ans > num) r = mid - 1;
            if (ans == num) return true;
        }
        return false;
    }

}
