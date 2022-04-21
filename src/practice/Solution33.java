package practice;

/**
 * 二分查找
 */
public class Solution33 {

    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return -1;
        if (n == 1) return nums[0] == target ? 0 : -1;
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] >= nums[0]) {
                if (nums[mid] > target && nums[0] <= target) r = mid - 1;
                else l = mid + 1;
            } else {
                if (nums[mid] < target && target <= nums[n - 1]) l = mid + 1;
                else r = mid - 1;
            }
        }
        return -1;
    }

}
