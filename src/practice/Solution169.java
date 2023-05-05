package practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 多数元素
 */
public class Solution169 {

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

}
