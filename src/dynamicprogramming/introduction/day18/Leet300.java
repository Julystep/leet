package dynamicprogramming.introduction.day18;


// 10,9,2,5,3,7,101,18
// 2 11 12 13 3 4 5 6 7
// 思路没错，问题在于可以利用dp函数来存储当前最长的有序数列，可自己的方式是定义变量且增加条件语句复杂度实现的，需要更改思路
public class Leet300 {

    // mine
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            dp[i] = 1;
        }
        int maxLen = 1;
        for (int i = 1; i < len; i++) {
            int cMaxLen = 1;
            for (int j = i - 1; j >= 0; j --) {
                if (nums[i] > nums[j] && cMaxLen <= dp[j]) {
                    dp[i] = dp[j] + 1;
                    cMaxLen = dp[j];
                }
            }
            maxLen = Math.max(dp[i], maxLen);
        }
        return maxLen;
    }

    // their
    public int lengthOfLIS1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }

}
