package practice;

import java.util.Arrays;

/**
 * 找规律
 */
public class Solution396 {

    public int maxRotateFunction(int[] nums) {
        int f = 0, n = nums.length, numSum = Arrays.stream(nums).sum();
        for (int i = 0; i < n; i++) {
            f += i * nums[i];
        }
        int res = f;
        for (int i = n - 1; i > 0; i--) {
            f += numSum - n * nums[i];
            res = Math.max(res, f);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] i = {4, 3, 2, 6};
        new Solution396().maxRotateFunction(i);
    }

}
