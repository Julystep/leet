package practice;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 二分查找
 */
public class Solution1337 {

    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<String> queue = new PriorityQueue<>((o1, o2) -> {
            String[] o1s = o1.split(":");
            String[] o2s = o2.split(":");
            if (o1s[1].equals(o2s[1])) {
                return Integer.parseInt(o1s[0]) - Integer.parseInt(o2s[0]);
            }
            return Integer.parseInt(o1s[1]) - Integer.parseInt(o2s[1]);
        });
        int i = 0;
        for (int[] item : mat) {
            queue.add(i++ + ":" + power(item));
        }
        int[] ans = new int[k];
        for (int j = 0; j < k; j++) {
            ans[j] = Integer.parseInt(queue.poll().split(":")[0]);
        }
        return ans;
    }

    private Integer power(int[] item) {
        int l = 0, r = item.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (item[mid] == 1) l = mid + 1;
            else r = mid - 1;
        }
        if (r == -1) {
            return 0;
        }
        return item[r] == 1 ? r + 1 : r;
    }

}
