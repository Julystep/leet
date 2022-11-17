import java.util.Arrays;

/**
 * 加一
 * @since 2022/11/16
 */
public class Solution66 {

    public int[] plusOne(int[] digits) {
        int[] ans = new int[digits.length + 1];
        int x = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] + x == 10) {
                ans[i + 1] = 0;
            } else {
                ans[i+1] = digits[i] + x;
                x = 0;
            }
        }
        if (x == 1) ans[0] = (digits[0] + 1) / 10;
        if (ans[0] == 0) return Arrays.copyOfRange(ans, 1, ans.length);
        else return ans;
    }

}
