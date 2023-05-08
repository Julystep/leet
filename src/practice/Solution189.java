package practice;

// 轮转数组
public class Solution189 {

    // 最简单的方法
    public void rotate(int[] nums, int k) {
        int[] cache = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            cache[(i + k) % nums.length] = nums[i];
        }
        System.arraycopy(cache, 0, nums, 0, nums.length);
    }

    // 数组反转
    public void rotate1(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

}
