package programmer.interview.golden.code;

import java.util.ArrayList;
import java.util.List;

/**
 * 幂集
 */
public class Solution32 {

    List<Integer> list = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        getSets(nums, 0);
        return ans;
    }

    private void getSets(int[] nums, int index) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[index]);
        getSets(nums, index + 1);
        list.remove(list.size() - 1);
        getSets(nums, index + 1);
    }

    public static void main(String[] args) {
        Solution32 solution32 = new Solution32();
        int[] x = {1,2,3,4};
        solution32.subsets(x);
    }

}
