package practice;

// 除自身以外数组的乘积
public class Solution238 {

    // 左右乘积表
    // 前缀和，不过没完全前缀，而是前后都计算，留中间的
    public int[] productExceptSelf(int[] nums) {
        int[] L = new int[nums.length];
        int[] R = new int[nums.length];
        L[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            L[i] = L[i - 1] * nums[i];
        }
        R[nums.length - 1] = nums[nums.length - 1];
        for (int j = nums.length - 2; j >= 0; j--) {
            R[j] = R[j + 1] * nums[j];
        }
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                nums[i] = R[i + 1];
            } else if (i == nums.length - 1) {
                nums[i] = L[i - 1];
            } else {
                nums[i] = L[i - 1] * R[i + 1];
            }
        }
        return nums;
    }

}
