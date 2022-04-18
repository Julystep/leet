package practice;

/**
 * 二分
 */
public class Solution74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] item : matrix) {
            if (target < item[0] || target > item[item.length - 1]) continue;
            if (find(item, target)) return true;
        }
        return false;
    }

    private boolean find(int[] item, int target) {
        int l = 0, r = item.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (item[mid] == target) return true;
            else if (item[mid] > target) r = mid - 1;
            else l = mid + 1;
        }
        return false;
    }

}
