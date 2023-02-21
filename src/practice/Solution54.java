package practice;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵
 */
public class Solution54 {



    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int x = matrix.length;
        int y = matrix[0].length;
        int total = x * y;
        int aimX = 0, aimY = 0;
        boolean[][] visited = new boolean[x][y];
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;
        for (int i = 0; i < total; i++) {
            ans.add(matrix[aimX][aimY]);
            visited[aimX][aimY] = true;
            int nextAimX = aimX + directions[directionIndex][0];
            int nextAimY = aimY + directions[directionIndex][1];
            if (nextAimX >= x || nextAimY >= y || nextAimX < 0 || nextAimY < 0 || visited[nextAimX][nextAimY]) {
                directionIndex = (directionIndex + 1) % 4;
            }
            aimX = aimX + directions[directionIndex][0];
            aimY = aimY + directions[directionIndex][1];
        }
        return ans;
    }

}
