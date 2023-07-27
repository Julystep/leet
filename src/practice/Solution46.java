package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author <a href="mailto:liml28084@hundsun.com">liml28084</a>
 * @since v
 * 全排列
 * @since 2023/7/27
 */
public class Solution46 {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {

        List<Integer> temp = new ArrayList<>();
        for (int num : nums) {
            temp.add(num);
        }

        int n = nums.length;
        dfs(temp, 0, n);
        return ans;

    }

    private void dfs(List<Integer> temp, int first, int n) {

        if (first == n) {
            ans.add(new ArrayList<>(temp));
        }
        for (int i = first; i < n; i++) {
            Collections.swap(temp, first, i);
            dfs(temp, first + 1, n);
            Collections.swap(temp, i, first);
        }

    }

}
