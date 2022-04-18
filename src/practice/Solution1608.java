package practice;

import java.util.Arrays;

/**
 * 二分
 */
public class Solution1608 {

    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i <= nums[nums.length - 1]; i++) {
            int l = 0, r = nums.length - 1;
            while (l < r) {
                int mid = (l + r) / 2;
                if (nums[mid] >= i) r = mid;
                else l = mid + 1;
            }
            if (nums.length - r == i) return i;
        }
        return -1;
    }

}
