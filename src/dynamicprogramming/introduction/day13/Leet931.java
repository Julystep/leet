package dynamicprogramming.introduction.day13;

public class Leet931 {

    public int minFallingPathSum(int[][] matrix) {
        int len = matrix.length;
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < len; j++) {

                if (j == 0) {
                    matrix[i][j] = Math.min(matrix[i-1][j] + matrix[i][j], matrix[i-1][j+1] + matrix[i][j]);
                } else if (j == len - 1) {
                    matrix[i][j] = Math.min(matrix[i-1][j] + matrix[i][j], matrix[i-1][j-1] + matrix[i][j]);
                } else {
                    matrix[i][j] = Math.min(Math.min(matrix[i-1][j] + matrix[i][j], matrix[i-1][j+1] + matrix[i][j]), matrix[i-1][j-1] + matrix[i][j]);
                }
            }
        }
        for (int i = 0; i < len; i++) {
            ans = Math.min(matrix[len-1][i], ans);
        }
        return ans;
    }


}
