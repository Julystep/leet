package practice;

import java.util.Arrays;

/**
 * 动态规划
 * 规划每个拥有的钱的数值的最小硬币花费
 */
public class Solution322 {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                int num = i - coin;
                if (num >= 0) {
                    dp[i] = Math.min(dp[num] + 1, dp[i]);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

}
