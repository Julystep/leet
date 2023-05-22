package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 矩阵置零
 */
public class Solution73 {

    public void setZeroes(int[][] matrix) {
        List<Integer> xs = new ArrayList<>();
        List<Integer> ys = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    xs.add(i);
                    ys.add(j);
                }
            }
        }
        for (Integer x : xs) {
            Arrays.fill(matrix[x], 0);
        }
        for (Integer y : ys) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][y] = 0;
            }
        }
    }
    
}
