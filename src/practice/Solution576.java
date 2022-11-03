package practice;

import java.util.Arrays;

/**
 * 出界的路径数
 * @since v0.0.0
 * @since 2022/11/3
 */
public class Solution576 {
    int MOD = (int)1e9+7;
    int m, n, max;
    int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    int[][][] cache;
    public int findPaths(int _m, int _n, int _maxMove, int r, int c) {
        m = _m; n =_n; max = _maxMove;
        final int MOD = 1000000007;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        cache = new int[m][n][max + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k <= max; k++) {
                    cache[i][j][k] = -1;
                }
            }
        }
        return dfs(r, c, max);
    }
    private int dfs(int r, int c, int max) {
        // 到界外的时候，+1;
        if (r < 0 || r >= m || c < 0 || c >= n) return 1;
        if (max == 0) return 0;
        if (cache[r][c][max] != -1) return cache[r][c][max];
        int ans = 0;
        for (int[] d : dirs) {
            int nx = r + d[0], ny = c + d[1];
            ans += dfs(nx, ny, max - 1);
            ans %= MOD;
        }
        cache[r][c][max] = ans;
        return ans;
    }

    public static void main(String[] args) {
        Solution576 solution576 = new Solution576();
        System.out.println(solution576.findPaths(1,3,3,0,1));
    }

}
