package practice;


public class Solution260 {

    public int[] singleNumber(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum ^= num;
        }
        int k = -1;
        for (int i = 0; i < 32 && k == -1; i++) {
            if (((sum >> i) & 1) == 1) k = i;
        }
        int ans1 = 0, ans2 = 0;
        for (int num : nums) {
            if (((num >> k) & 1) == 1) ans1 ^= num;
            else ans2 ^= num;
        }
        return new int[]{ans1, ans2};
    }

    public static void main(String[] args) {
        System.out.println(2 ^ 3);
    }

}
