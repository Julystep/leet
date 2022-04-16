package practice;

/**
 * 二分查找
 */
public class Solution1539 {

    public int findKthPositive(int[] arr, int k) {
        if (arr[0] > k) {
            return k;
        }
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = (l + r) >> 1;
            int x = mid < arr.length ? arr[mid] : Integer.MAX_VALUE;
            if (x - mid - 1 >= k) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return k - (arr[l - 1] - (l - 1) - 1) + arr[l - 1];
    }

}
