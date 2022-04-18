package practice;

import java.util.Arrays;

/**
 * 二分
 */
public class Solution1351 {

    public int countNegatives(int[][] grid) {
        int[] f = new int[grid.length * grid[0].length];
        int size = 0;
        for (int[] item : grid) {
            for (int i = item.length - 1; i>=0; i--) {
                if (item[i] < 0) size++;
                else break;
            }
        }
        return size;
    }

}
