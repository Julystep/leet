package practice;

public class Solution852 {

    public int peakIndexInMountainArray(int[] arr) {
        int l = 1, r = arr.length - 1, ans = 0;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] > arr[mid+1]) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

}
