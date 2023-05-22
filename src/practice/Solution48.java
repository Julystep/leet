package practice;

/**
 * 旋转图像
 */
public class Solution48 {

    //上下对称：matrix[i][j] -> matrix[n-i-1][j]，（列不变）
    //左右对称：matrix[i][j] -> matrix[i][n-j-1]，（行不变）
    //主对角线对称：matrix[i][j] -> matrix[j][i]，（行列互换）
    //副对角线对称：matrix[i][j] -> matrix[n-j-1][n-i-1] （行列均变，且互换）
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < (n + 1) / 2; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }

}
