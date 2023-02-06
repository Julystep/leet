package practice;

/**
 * 买卖股票的最佳时机
 */
public class Solution121 {

    public int maxProfit(int[] prices) {
        int profit = -prices[0];
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            ans = Math.max(ans, prices[i] + profit);
            profit = Math.max(profit, -prices[i]);
        }
        return ans;
    }

}
