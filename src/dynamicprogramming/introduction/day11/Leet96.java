package dynamicprogramming.introduction.day11;


public class Leet96 {

    // 以某一个点x为根，则在这种情况下能产生的二叉搜索树 为 f(x - 1) * f (n - x)
    // 思维盲点： 对于同时要处理子并且将子利用起来没想到
    // 题目方式: 首先当左子树或右子树为空或1时，取1，并创建两层循环，第一层循环限制当前的数据量
    // 第二条循环用于分隔子树，并利用之前的字数结果

    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1; dp[1] = 1;
        for (int i = 2; i <= n; i ++) {
            for (int j = 1; j <= i; j ++) {
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }

}
