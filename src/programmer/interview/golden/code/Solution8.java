package programmer.interview.golden.code;

import java.util.*;

/**
 * 零矩阵
 */
public class Solution8 {

    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    int[] item = {i, j};
                    list.add(item);
                }
            }
        }
        for (int[] item : list) {
            for (int i = 0; i < n; i++) {
                matrix[item[0]][i] = 0;
            }
            for (int i = 0; i < m; i++) {
                matrix[i][item[1]] = 0;
            }
        }
    }

}
