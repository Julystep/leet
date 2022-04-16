package practice;

import java.util.Arrays;

public class Solution213 {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(robSplit(nums, 0, nums.length - 2), robSplit(nums, 1, nums.length - 1));
    }

    public int robSplit(int[] splitNums, int l, int r) {
        int first = splitNums[l], second = Math.max(splitNums[l], splitNums[l+1]);
        for (int i = l + 2; i <= r; i++) {
            int tmp = Math.max(first + splitNums[i], second);
            first = second;
            second = tmp;
        }
        return second;
    }

}
