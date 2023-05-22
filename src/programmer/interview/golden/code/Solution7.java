package programmer.interview.golden.code;

/**
 * 旋转矩阵
 */
public class Solution7 {

    public void rotate(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] result = new int[n][m];
        int a = 0, b = 0;
        for (int j = 0; j < n; j++) {
            a = j;
            for (int i = m - 1; i >= 0; i--) {
                b = m - 1 - i;
                result[a][b] = matrix[i][j];
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = result[i][j] ;
            }
        }
    }

    public void rotate1(int[][] matrix) {
//        int n = matrix.length;
//        for (int i = 0; i < n / 2; ++i) {
//            for (int j = 0; j < (n + 1) / 2; ++j) {
//                int temp = matrix[i][j];
//                matrix[i][j] = matrix[n - j - 1][i];
//                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
//                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
//                matrix[j][n - i - 1] = temp;
//            }
//        }
    }

    public static void main(String[] args) {
        Solution7 solution7 = new Solution7();
        int[][] n = {{1, 2, 3}, {4, 5, 6}, {7, 8 ,9}};
        solution7.rotate(n);
    }

}
