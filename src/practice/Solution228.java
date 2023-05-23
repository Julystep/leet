package practice;

import java.util.ArrayList;
import java.util.List;

/**
 * 汇总区间
 */
public class Solution228 {

    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        int start = 0, end = start;
        while (end < nums.length) {
            if (end + 1 < nums.length && nums[end + 1] - nums[end] == 1) {
                end ++;
            } else {
                if (start == end) {
                    ans.add("" + nums[start]);
                } else {
                    ans.add("" + nums[start] + "->" + nums[end]);
                }
                end ++;
                start = end;
            }
        }
        return ans;
    }

}
