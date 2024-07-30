package practice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 双模幂运算
 *
 * @author liminglei
 */
public class Solution2961 {

    public List<Integer> getGoodIndices(int[][] variables, int target) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < variables.length; i++) {
            int[] v = variables[i];
            if (powMod(powMod(v[0], v[1], 10), v[2], v[3]) == target) {
                ans.add(i);
            }
        }
        return ans;
    }

    public int powMod(int x, int y, int mod) {
        int res = 1;
        while (y != 0) {
            if ((y & 1) != 0) {
                res = res * x % mod;
            }
            x = x * x % mod;
            y >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] params = {{2, 3, 3, 10}, {3, 3, 3, 1}, {6, 1, 1, 4}};
        Solution2961 solution = new Solution2961();
        System.out.println(solution.getGoodIndices(params, 2));
        System.out.println(3 >> 1);
    }

}
