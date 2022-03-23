package dynamicprogramming.introduction.day16;


import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

// 最大正方形
// 不要老纠结目标，目标是通过边*边得到的，规划一下就能出来
public class Leet221 {

    public int maximalSquare(char[][] matrix) {
        int max = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i ++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    }
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max * max;
    }

    public static void main(String[] args) {
        String[] str = {"2", "12"};
        Arrays.sort(str);
        System.out.println(str);
    }

}
