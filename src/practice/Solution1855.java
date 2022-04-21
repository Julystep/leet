package practice;

public class Solution1855 {

    /**
     * 二分解法
     * @param nums1
     * @param nums2
     * @return
     */
    public int maxDistance(int[] nums1, int[] nums2) {
        int ans = 0;
        for (int i = 0; i < nums1.length && i < nums2.length; i++) {
            ans = Math.max(ans, split(nums1[i], nums2, i));
        }
        return ans;
    }

    private int split(int target, int[] nums2, int aim) {
        int left = aim, right = nums2.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums2[mid] >= target) left = mid + 1;
            else if (nums2[mid] < target) right = mid - 1;
        }
        if (right < 0) return 0;
        return right - aim;
    }


    /**
     * 双指针
     * @param nums1
     * @param nums2
     * @return
     */
    public int maxDistance1(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int i = 0, res = 0;
        for (int j = 0; j < l2; j++) {
            while (i < l1 && nums1[i] > nums2[j]) {
                ++i;
            }
            if (i < l1) {
                res = Math.max(res, j - i);
            }
        }
        return res;
    }
}
