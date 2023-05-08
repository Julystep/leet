package practice;

import java.util.Arrays;

/**
 * 合并两个有序数组
 */
public class Solution88 {

    // 第一种方法，先放进去，再排序
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i != n; ++i) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }

    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1;
        int len = m + n - 1;
        while (p1 != -1 || p2 != -1) {
            if (p1 == -1) {
                nums1[len--] = nums2[p2--];
            } else if (p2 == -1) {
                nums1[len--] = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                nums1[len--] = nums1[p1--];
            } else {
                nums1[len--] = nums2[p2--];
            }
        }
    }

}
