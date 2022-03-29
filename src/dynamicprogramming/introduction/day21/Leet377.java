package dynamicprogramming.introduction.day21;


public class Leet377 {

    // 输入：nums = [1,2,3], target = 4
    // 输出：7
    // 解释：
    // 所有可能的组合为：
    // (1, 1, 1, 1)
    // (1, 1, 2)
    // (1, 2, 1)
    // (1, 3)
    // (2, 1, 1)
    // (2, 2)
    // (3, 1)
    // 请注意，顺序不同的序列被视作不同的组合。

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] += dp[i-num];
                }
            }
        }
        return dp[target];
    }

}
