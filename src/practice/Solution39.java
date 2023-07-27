package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 组合总和
 *
 * @author <a href="mailto:liml28084@hundsun.com">liml28084</a>
 * @since v
 * @since 2023/7/27
 */
public class Solution39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combine = new ArrayList<>();
        dfs(candidates, target, ans, combine, 0);
        return ans;
    }

    public void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int idx) {
        if (idx == candidates.length) return;
        if (target == 0) {
            ans.add(new ArrayList<>(combine));
            return;
        }
        dfs(candidates, target, ans, combine, idx + 1);

        if (target - candidates[idx] >= 0) {
            combine.add(candidates[idx]);
            dfs(candidates, target - candidates[idx], ans, combine, idx);
            combine.remove(combine.size() - 1);
        }
    }

}
