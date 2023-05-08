package practice;

import java.util.Arrays;

public class Solution27 {

    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != val) {
                nums[left++] = nums[right];
            }
        }
        return left;
    }

}
