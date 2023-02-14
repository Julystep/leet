package practice;

import java.util.HashMap;
import java.util.Map;

/**
 * 表现良好的最长时间段
 */
public class Solution1124 {

    public int longestWPI(int[] hours) {
        int ans = 0;
        int[] prefixSum = new int[hours.length + 1];
        int sum = 0;
        for (int i = 0; i < hours.length; i++) {
            prefixSum[i] = sum;
            sum += hours[i] > 8 ? 1 : -1;
        }
        prefixSum[hours.length] = sum;
        for (int i = 0; i < prefixSum.length; i++) {
            for (int j = prefixSum.length - 1; j > i; j--) {
                if (prefixSum[i] < prefixSum[j]) {
                    ans = Math.max(j - i, ans);
                }
            }
        }
        return ans;
    }

}
