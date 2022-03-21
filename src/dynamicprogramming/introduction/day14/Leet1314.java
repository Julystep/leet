package dynamicprogramming.introduction.day14;


// 矩阵区域和
// 利用数组的前缀和，统计好前缀和后就可使用动态规划.

public class Leet1314 {

    // 通过前缀和实现
    public int[][] matrixBlockSum(int[][] mat, int k) {
        // 构造前缀和数组
        int[][] preNum = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                preNum[i][j] = makePreNum(preNum, i, j - 1) + makePreNum(preNum, i - 1, j) - makePreNum(preNum, i - 1, j - 1) + mat[i][j];
            }
        }
        // 利用前缀和数组求出当前数组中的参数。
        int[][] answer = new int[mat.length][mat[0].length];
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[0].length; j++) {
                answer[i][j] = getAnswer(preNum, i + k, j + k) + getAnswer(preNum, i - k - 1, j - k - 1) - getAnswer(preNum, i - k - 1, j + k) - getAnswer(preNum, i + k, j - k - 1);
            }
        }
        return answer;
    }

    private int getAnswer(int[][] preNum, int i, int j) {
        if (i < 0 || j < 0) return 0;
        i = Math.min(preNum.length - 1, i);
        j = Math.min(preNum[0].length - 1, j);
        return preNum[i][j];
    }

    private int makePreNum(int[][] preNum, int i, int j) {
        if (i < 0 || j < 0) return 0;
        return preNum[i][j];
    }


}
