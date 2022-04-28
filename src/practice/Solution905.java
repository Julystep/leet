package practice;

public class Solution905 {

    public int[] sortArrayByParity(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            if (nums[l] % 2 == 1 && nums[r] % 2 == 0) {
                int tmp = nums[l];
                nums[l] = nums[r];
                nums[r] = tmp;
                l++;
                r--;
            } else if (nums[l] % 2 == 0){
                l++;
            } else {
                r--;
            }
        }
        return nums;
    }

}
