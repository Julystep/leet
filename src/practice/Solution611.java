package practice;

import java.util.Arrays;

public class Solution611 {

    /**
     * 二分,最暴力的方法优化了下
     * @param nums
     * @return
     */
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int l = j + 1, r = n - 1;
                int k = j;
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    if (nums[mid] < nums[i] + nums[j]) {
                        k = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                ans += k - j;
            }
        }
        return ans;
    }

    /**s
     * 双指针
     * 俩指针主要指的k和j
     * @param nums
     * @return
     */
    public int triangleNumberSplit(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int k = 0;
            for (int j = i + 1; j < n; j++) {
                while (k + 1 < n && nums[k+1] < nums[i] + nums[j]) k++;
                ans += Math.max(k - j, 0);
            }
        }
        return ans;
    }

}
