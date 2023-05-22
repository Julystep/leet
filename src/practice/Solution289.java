package practice;

/**
 * 生命游戏
 */
public class Solution289 {

    public void gameOfLife(int[][] board) {
        int x = board.length;
        int y = board[0].length;
        int[][] cache = new int[x][y];
        int[] neighbors = {0, 1, -1};
        for (int i = 0; i < x; i++) {
            System.arraycopy(board[i], 0, cache[i], 0, y);
        }

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                int liveNeighbors = 0;
                for (int a = 0; a < 3; a++) {
                    for (int b = 0; b < 3; b++) {
                        if (!(neighbors[a] == 0 && neighbors[b] == 0)) {
                            int r = (i + neighbors[a]);
                            int c = (j + neighbors[b]);
                            // 查看相邻的细胞是否是活细胞
                            if ((r < x && r >= 0) && (c < y && c >= 0) && (cache[r][c] == 1)) {
                                liveNeighbors += 1;
                            }
                        }
                    }
                }
                if (cache[i][j] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    board[i][j] = 0;
                }

                if (cache[i][j] == 0 && liveNeighbors == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution289 solution289 = new Solution289();
        int[][] x = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        solution289.gameOfLife(x);
    }
}
