package practice;

/**
 * 删除有序数组中的重复项 II

 */
public class Solution80 {

    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] == nums[j]) {
                if (i == 0 || nums[i-1] != nums[i]) {
                    ++i;
                    nums[i] = nums[j];
                }
            } else {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int[] x = {0,0,1,1,1,1,2,3,3};
        Solution80 solution80 = new Solution80();
        solution80.removeDuplicates(x);
    }

}
