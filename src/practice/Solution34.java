package practice;

/**
 * 二分查找
 */

public class Solution34 {

    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        if (nums.length == 0) {
            return ans;
        }
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) l = mid + 1;
            if (nums[mid] >= target) r = mid;
        }
        if (nums[r] == target) {
            ans[0] = r;
            while (r < nums.length && nums[r] == target) {
                r++;
            }
            ans[1] = r - 1;
        }
        return ans;
    }

}
