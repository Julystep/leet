package practice;

/**
 * 第一个错误的版本
 */
public class Solution278 {

    public int firstBadVersion(int n) {
        int l = 1, r = n;
        while (l < r) {
            int mid = (r -l) /2 + l;
            if (isBadVersion(mid)) r = mid;
            if (!isBadVersion(mid)) l = mid + 1;
        }
        return l;
    }

    private boolean isBadVersion(int mid) {
        return mid == 3;
    }

}
