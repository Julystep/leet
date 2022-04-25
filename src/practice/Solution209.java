package practice;

import java.util.Arrays;

/**
 *
 */
public class Solution209 {

    /**
     * 官方
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0, r = 0;
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        while (r < nums.length) {
            sum += nums[r];
            while (sum >= target) {
                ans = Math.min(ans, r - l + 1);
                sum -= nums[l++];
            }
            r++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    // 有点类似官方滑动窗口
    public int minSubArrayLenMine(int target, int[] nums) {
        int l = 0, r = -1;
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        while (r + 1 < nums.length && l < nums.length) {
            r++;
            sum += nums[r];
            if (l == r && nums[l] >= target) {
                return 1;
            }
            while (sum >= target && r >= l) {
                ans = Math.min(ans, r - l + 1);
                sum -= nums[l++];
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }


    /**
     * 二分查找在Arrays.bianrySearch
     * 计算前缀和构造递增数组
     * 每次查询时，比当前数据
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLenSplit(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int[] sums = new int[n + 1];
        // 为了方便计算，令 size = n + 1
        // sums[0] = 0 意味着前 0 个元素的前缀和为 0
        // sums[1] = A[0] 前 1 个元素的前缀和为 A[0]
        // 以此类推
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        for (int i = 1; i <= n; i++) {
            int target = s + sums[i - 1];
            int bound = Arrays.binarySearch(sums, target);
            if (bound < 0) {
                bound = -bound - 1;
            }
            if (bound <= n) {
                ans = Math.min(ans, bound - (i - 1));
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static void main(String[] args) {
        int[] i = {2,3,1,2,4,3};
        System.out.println(new Solution209().minSubArrayLenSplit(7, i));
    }


}
