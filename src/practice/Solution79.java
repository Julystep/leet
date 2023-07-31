package practice;


import java.util.Arrays;

public class Solution79 {

    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    for (boolean[] item : visited) Arrays.fill(item, false);
//                    visited[i][j] = true;
                    if (dfs(visited, board, i, j, m, n, word, 0)) return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(boolean[][] visited, char[][] board, int x, int y, int m, int n, String word, int index) {
        if (index == word.length()) return true;
        if (x < 0 || y < 0 || x >= m || y >= n) return false;
        if (visited[x][y]) return false;
        if (board[x][y] == word.charAt(index)) {
            visited[x][y] = true;
            boolean res = dfs(visited, board, x-1, y, m, n, word, index+1) ||
                    dfs(visited, board, x+1, y, m, n, word, index+1) ||
                    dfs(visited, board, x, y-1, m, n, word, index+1) ||
                    dfs(visited, board, x, y+1, m, n, word, index+1);
            visited[x][y] = false;
            return res;
        } else {
            return false;
        }

    }




    public static void main(String[] args) {
        Solution79 solution79 = new Solution79();
        char[][] board = {{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
        String word = "ABCESEEEFS";
        System.out.println(solution79.exist(board, word));
    }

}
