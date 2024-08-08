package practice;

/**
 * @author liminglei
 */
public class Solution3131 {

    public int addedInteger(int[] nums1, int[] nums2) {
        int smallestNum1 = Integer.MAX_VALUE;
        int smallestNum2 = Integer.MAX_VALUE;
        for (int num1 : nums1) {
            if (num1 < smallestNum1) {
                smallestNum1 = num1;
            }
        }
        for (int num2 : nums2) {
            if (num2 < smallestNum2) {
                smallestNum2 = num2;
            }
        }
        return smallestNum2 - smallestNum1;
    }

}
