package practice;

/**
 * 双指针
 */
public class Solution633 {

    public boolean judgeSquareSum(int c) {
        long l = 0;
        long r = (long) Math.sqrt(c);
        while (l <= r) {
            long x = l * l + r * r;
            if (x < c) l++;
            else if (x > c) r--;
            else return true;
        }
        return false;
    }

}
