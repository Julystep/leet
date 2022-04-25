package practice;

import java.util.*;

/**
 * hash
 */
public class Solution398  {

    Map<Integer, List<Integer>> pos;
    Random random;

    public Solution398(int[] nums) {
        pos = new HashMap<Integer, List<Integer>>();
        random = new Random();
        for (int i = 0; i < nums.length; ++i) {
            pos.putIfAbsent(nums[i], new ArrayList<>());
            pos.get(nums[i]).add(i);
        }
    }

    public int pick(int target) {
        List<Integer> indices = pos.get(target);
        return indices.get(random.nextInt(indices.size()));
    }


}
