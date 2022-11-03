package practice;

import java.util.Arrays;

/**
 * 统计所有可行路径
 * @since v11
 * @since 2022/11/3
 */
public class Solution1575 {
    int mod = 1000000007;
    int[][] result;
    public int countRoutes(int[] ls, int start, int end, int fuel) {
        result = new int[ls.length][fuel + 1];
        for (int i = 0; i < ls.length; i++) {
            Arrays.fill(result[i], -1);
        }
        return dfs(ls, start, end, fuel);
    }
    private int dfs(int[] ls, int start, int end, int fuel) {
        // 如果已经走过了，就不是-1;
        if (result[start][fuel] != -1) return result[start][fuel];
        if (fuel == 0 && start != end) {
            result[start][fuel] = 0;
            return 0;
        }
        boolean hasNext = false;
        for (int i = 0; i < ls.length; i++) {
            if (i != start) {
                int need = Math.abs(ls[start] - ls[i]);
                if (fuel >= need) {
                    hasNext = true;
                    break;
                }
            }
        }
        if (fuel != 0 && !hasNext) {
            result[start][fuel] = start == end ? 1 : 0;
            return result[start][fuel];
        }
        // 如果开始和结束相同，就有一条路，否则为0
        int sum = start == end ? 1 : 0;
        for (int i = 0; i < ls.length; i++) {
            if (i != start) {
                int need = Math.abs(ls[i] - ls[start]);
                if (fuel >= need) {
                    sum += dfs(ls, i, end, fuel - need);
                    sum %= mod;
                }
            }
        }
        result[start][fuel] = sum;
        return sum;
    }

    public int countRoutes1(int[] ls, int start, int end, int fuel) {
        int n = ls.length;

        // f[i][j] 代表从位置 i 出发，当前油量为 j 时，到达目的地的路径数
        int[][] f = new int[n][fuel + 1];

        // 对于本身位置就在目的地的状态，路径数为 1
        for (int i = 0; i <= fuel; i++) f[end][i] = 1;

        // 从状态转移方程可以发现 f[i][fuel]=f[i][fuel]+f[k][fuel-need]
        // 在计算 f[i][fuel] 的时候依赖于 f[k][fuel-need]
        // 其中 i 和 k 并无严格的大小关系
        // 而 fuel 和 fuel-need 具有严格大小关系：fuel >= fuel-need
        // 因此需要先从小到大枚举油量
        for (int cur = 0; cur <= fuel; cur++) {
            for (int i = 0; i < n; i++) {
                for (int k = 0; k < n; k++) {
                    if (i != k) {
                        int need = Math.abs(ls[i] - ls[k]);
                        if (cur >= need) {
                            f[i][cur] += f[k][cur-need];
                            f[i][cur] %= mod;
                        }
                    }
                }
            }
        }
        return f[start][fuel];
    }

}
