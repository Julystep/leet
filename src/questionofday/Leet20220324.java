package questionofday;

// 首先进行的是基础的遍历，之后在遍历的基础上，仿造出一个 3*3 的九宫格，之后将九宫格中不存在的数据剔除，存在的就是结果

public class Leet20220324 {

    // 输入:img = [[1,1,1],[1,0,1],[1,1,1]]
    // 输出:[[0, 0, 0],[0, 0, 0], [0, 0, 0]]
    // img[i][j] = img[i-1][j] + img[i+1][j] + img[i][j-1] + img[i][j+1] + img[i+1][j+1] + img[i-1][j-1] + img[i-1][j+1] + img[i+1][j-1]
    public int[][] imageSmoother(int[][] img) {
        int m = img.length, n = img[0].length;
        int[][] ret = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int num = 0, sum = 0;
                for (int x = i - 1; x <= i + 1; x++) {
                    for (int y = j - 1; y <= j + 1; y++) {
                        if (x >= 0 && x < m && y >= 0 && y < n) {
                            num++;
                            sum += img[x][y];
                        }
                    }
                }
                ret[i][j] = sum / num;
            }
        }
        return ret;
    }

}
