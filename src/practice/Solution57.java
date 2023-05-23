package practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 插入区间
 */
public class Solution57 {

    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> all = new ArrayList<>();
        all.add(newInterval);
        for (int[] interval : intervals) {
            all.add(new int[]{interval[0], interval[1]});
        }
        all.sort(Comparator.comparingInt(o -> o[0]));
        List<int[]> merged = new ArrayList<>();
        for (int[] interval : all) {
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(new int[]{interval[0], interval[1]});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(interval[1], merged.get(merged.size() - 1)[1]);
            }
        }
        return merged.toArray(new int[merged.size()][2]);
    }

    public int[][] insert1(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];
        List<int[]> list = new ArrayList<>();
        boolean placed = false;
        for (int[] interval : intervals) {
            if (interval[0] > right) {
                if (!placed) {
                    list.add(new int[]{left, right});
                    placed = true;
                }
                list.add(interval);
            } else if (interval[1] < left) {
                list.add(interval);
            } else {
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }
        if (!placed) {
            list.add(new int[]{left, right});
        }
        return list.toArray(new int[list.size()][2]);
    }


    public static void main(String[] args) {
        Solution57 solution57 = new Solution57();

        int[][] x = {{1,3},{6,9}};
        int[] y = {2, 5};

        solution57.insert(x, y);
    }

}
