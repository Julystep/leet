package practice;

public class Solution132 {

    /**
     * java 的 2 ^ 31 次方是 2 ^ 31 - 1
     */
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int total = 0;
            for (int num : nums) {
                total += (num >> i) & 1;
            }
            if (total % 3 > 0) {
                ans |= 1 << i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution132 solution132 = new Solution132();
        System.out.println(solution132.singleNumber(new int[]{1}));
    }

}
