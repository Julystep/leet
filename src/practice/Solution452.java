package practice;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 用最少数量的箭引爆气球
 */
public class Solution452 {

    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        Arrays.sort(points, Comparator.comparingInt(point -> point[1]));
        int position = points[0][1];
        int ans = 1;
        for (int[] point : points) {
            if (point[0] > position) {
                ans++;
                position = point[1];
            }
        }
        return ans;
    }

}
