package practice;

public class Solution724 {

    public int pivotIndex(int[] nums) {
        int r = 0;
        for (int num : nums) {
            r += num;
        }
        int l = 0;
        for (int i = 0; i < nums.length; i++) {
            if (l == r - nums[i]) return i;
            r -= nums[i];
            l += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] i = {1,7,3,6,5,6};
        Solution724 solution724 = new Solution724();
        solution724.pivotIndex(i);

    }

}
