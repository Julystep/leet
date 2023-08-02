package practice;


import java.util.Arrays;

public class Solution300 {

    /**
     * 输入：nums = [10,9,2,5,3,7,101,18]
     * 输出：4
     * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
     */
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[nums.length];
        int maxLen = 1;
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Solution300 solution300 = new Solution300();
        solution300.lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6});
    }

}
