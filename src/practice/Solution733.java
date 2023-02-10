package practice;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 图像渲染
 */
public class Solution733 {

    /**
     *
     */

    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};


    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldColor = image[sr][sc];
        int xLen = image.length;
        int yLen = image[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{sr, sc});
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0], y = point[1];
            image[x][y] = color;
            for (int i = 0; i < 4; i++) {
                int px = x + dx[i], py = y + dy[i];
                if (px < 0 || px >= xLen || py < 0 || py >= yLen || image[px][py] == color || image[px][py] != oldColor ) continue;
                queue.offer(new int[]{px, py});
            }
        }
        return image;
    }

}
