import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 完全平方数
 * @since v0.0.0
 * @since 2022/11/4
 */
public class Solution279 {

    List<Integer> squar = new ArrayList<>();
    public int numSquares(int n) {
        int[] ans = new int[n+1];
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j * j <= i; j++) {
                min = Math.min(min, ans[i - j * j]);
            }
            ans[i] = min + 1;
        }
        return ans[n];
    }

    public static void main(String[] args) {
        Solution279 solution279 = new Solution279();
        System.out.println(solution279.numSquares(12));
    }

}
