package practice;

/**
 * 删除有序数组中的重复项
 */
public class Solution26 {

    public int removeDuplicates(int[] nums) {

        int l = 0, r = 0, len = 0;
        int i = 0;
        while (i < nums.length) {
            while (r < nums.length && nums[l] == nums[r]) {
                r ++;
            }
            if (l >= nums.length) break;
            nums[len++] = nums[l];
            l = r;
        }
        return len;

    }

    public int removeDuplicates1(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                ++i;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

}
