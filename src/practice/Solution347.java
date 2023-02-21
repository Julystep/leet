package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 前 K 个高频元素

 */
public class Solution347 {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) map.put(num, 0);
            map.put(num, map.get(num) + 1);
        }
        List<Integer> ans = new ArrayList<>(map.keySet());
        ans.sort((n1, n2) -> map.get(n2) - map.get(n1));
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = ans.get(i);
        }
        return result;
    }

}
