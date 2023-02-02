package practice;

import java.util.*;

/**
 * 颜色交替的最小路径
 */
public class Solution1129 {

    /*

    节点分别标记为 0 - n-1

     */

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<Integer>[][] next = new List[2][n];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                next[i][j] = new ArrayList<>();
            }
        }
        for (int []edge : redEdges) {
            next[0][edge[0]].add(edge[1]);
        }
        for (int []edge : blueEdges) {
            next[1][edge[0]].add(edge[1]);
        }
        int[][] dist = new int[2][n];
        for (int i = 0; i < 2; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0] = 0;
        dist[1][0] = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0});
        queue.add(new int[]{0, 1});
        while (!queue.isEmpty()) {
            int[] pair = queue.poll();
            int x = pair[0], t = pair[1];
            for (int y : next[1-t][x]) {
                if (dist[1-t][y] != Integer.MAX_VALUE) continue;
                dist[1-t][y] = dist[t][x] + 1;
                queue.add(new int[]{x, 1-t});
            }
        }
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = Math.min(dist[0][i], dist[1][i]);
            if (answer[i] == Integer.MAX_VALUE) {
                answer[i] = -1;
            }
        }
        return answer;
    }

}
