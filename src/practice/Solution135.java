package practice;

import java.util.Arrays;

/**
 * 分发糖果
 */
public class Solution135 {

    // 先左遍历再右遍历
    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] left = new int[len];
        for (int i = 0; i < len; i++) {
            if (i > 0 && ratings[i] > ratings[i-1]) {
                left[i] = left[i-1] + 1;
            } else {
                left[i] = 1;
            }
        }
        int right = 0;
        int ans = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (i < len - 1 && ratings[i] > ratings[i+1]) {
                right ++;
            } else {
                right = 1;
            }
            ans += Math.max(left[i], right);
        }
        return ans;
    }

    public int candy1(int[] ratings) {
        int len = ratings.length;
        int[] nums = new int[len];
        Arrays.fill(nums, 1);
        for (int i = 1; i < len; i++) {
            if (ratings[i-1] < ratings[i]) nums[i] = nums[i-1] + 1;
        }
        for (int i = len - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1] && nums[i] <= nums[i+1]) nums[i] = nums[i+1] + 1;
        }
        int ans = 0;
        for (int i = 0; i < len; i++) {
            ans += nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
//        Solution135 solution135 = new Solution135();
//        int[] x = {1, 2, 3, 4, 5};
//        System.out.println(solution135.candy(x));
    }

}
