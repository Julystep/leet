package practice;

import java.util.*;

/**
 * 三数之和
 */
public class Solution15 {

    // -1,0,1,2,-1,-4
    // -4 -1 -1 0 1  2
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        Set<String> set = new HashSet<>();
        for (int i = 0; i < nums.length / 2 + 1; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] < nums[i]) {
                    left ++;
                } else if (nums[left] + nums[right] > nums[i]) {
                    right --;
                } else {
                    if (set.add(nums[i]+"" + nums[left] + "" + nums[right])) {
                        set.add(nums[i]+"" + nums[left] + "" + nums[right]);
                        List<Integer> list = Arrays.asList(nums[i], nums[left], nums[right]);
                        ans.add(list);
                    }
                    left++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution15 solution15 = new Solution15();
        int[] x = {0,-4,-1,-4,-2,-3,2};
        solution15.threeSum(x);
    }

}
