package practice;

/**
 * 利用二分可解，本次问题在于 l + r 可能会超出int的长度，所以要规避长度限制
 */

public class Solution374 {
    public int guessNumber(int n) {
        int l = 1, r = n;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (guess(mid) == -1) r = --mid;
            else if (guess(mid) == 0) return mid;
            else l = ++mid;
        }
        return -1;
    }
    private int guess(int i) {
        return i;
    }
}
