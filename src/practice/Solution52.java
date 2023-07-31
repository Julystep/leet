package practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * n皇后
 */
public class Solution52 {

    List<int[]> points = new ArrayList<>();
    int ans;

    public int totalNQueens(int n) {
        dfs(0, n);
        return ans;
    }

    private void dfs(int c, int n) {
        if (c == n) {
            ans += 1;
            return;
        }
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            for (int[] point : points) {
                if (i == point[0] || c == point[1] || Math.abs(point[1] - c) == Math.abs(point[0] - i)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                points.add(new int[]{i, c});
                dfs(c+1, n);
                points.remove(points.size() - 1);
            }
        }
    }

    public int totalNQueens1(int n) {
        Set<Integer> columns = new HashSet<>();
        Set<Integer> diagonals1 = new HashSet<>();
        Set<Integer> diagonals2 = new HashSet<>();
        return backtrack(n, 0, columns, diagonals1, diagonals2);
    }

    public int backtrack(int n, int row, Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
        if (row == n) {
            return 1;
        } else {
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (columns.contains(i)) {
                    continue;
                }
                int diagonal1 = row - i;
                if (diagonals1.contains(diagonal1)) {
                    continue;
                }
                int diagonal2 = row + i;
                if (diagonals2.contains(diagonal2)) {
                    continue;
                }
                columns.add(i);
                diagonals1.add(diagonal1);
                diagonals2.add(diagonal2);
                count += backtrack(n, row + 1, columns, diagonals1, diagonals2);
                columns.remove(i);
                diagonals1.remove(diagonal1);
                diagonals2.remove(diagonal2);
            }
            return count;
        }
    }

    public static void main(String[] args) {
        Solution52 solution52 = new Solution52();
        System.out.println(solution52.totalNQueens(4));
    }

}
