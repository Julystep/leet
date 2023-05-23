package practice;

import java.util.Arrays;

/**
 * 最长连续序列
 */
public class Solution128 {


    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        if (nums.length == 0) return 0;
        int ans = 1, cache = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i-1] == 1) {
                cache++;
            } else if(nums[i] == nums[i-1]) {
                continue;
            } else {
                ans = Math.max(ans, cache);
                cache = 1;
            }
        }
        ans = Math.max(ans, cache);
        return ans;
    }

}
