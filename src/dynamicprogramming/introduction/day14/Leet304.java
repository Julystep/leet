package dynamicprogramming.introduction.day14;


public class Leet304 {

    class NumMatrix {

        int[][] preNum;

        public NumMatrix(int[][] matrix) {
            // 构造一个前缀和数组
            preNum = new int[matrix.length][matrix[0].length];
            for (int i = 0; i < matrix.length; i ++) {
                for (int j = 0; j < matrix[0].length; j ++) {
                    preNum[i][j] = preNum[i][j] = makePreNum(preNum, i, j - 1) + makePreNum(preNum, i - 1, j) - makePreNum(preNum, i - 1, j - 1) + matrix[i][j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return getAnswer(preNum, row1, col1) - getAnswer(preNum, row2, col1 - 1) - getAnswer(preNum, row1 - 1, col2) + getAnswer(preNum, row1 - 1, col1 - 1);
        }

        private int makePreNum(int[][] preNum, int i, int j) {
            if (i < 0 || j < 0) return 0;
            return preNum[i][j];
        }

        private int getAnswer(int[][] preNum, int i, int j) {
            if (i < 0 || j < 0) return 0;
            return preNum[i][j];
        }
    }


}
