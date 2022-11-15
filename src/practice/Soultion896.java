import java.util.Arrays;
import java.util.Collections;

/**
 * 单调数列
 *
 * @since 2022/11/15
 */
public class Soultion896 {

    public boolean isMonotonic(int[] nums) {
        if (nums.length == 1) return true;
        int pre = 0, nex = 1;
        int direction = 0;
        for (; nex < nums.length; nex++, pre++) {
            if (nums[pre] == nums[nex]) continue;
            else if (nums[pre] < nums[nex]) {
                if (direction == 2) return false;
                direction = 1;
            } else if (nums[pre] > nums[nex]) {
                if (direction == 1) return false;
                direction = 2;
            }
        }
        return true;
    }

    public boolean isMonotonic1(int[] nums) {
        boolean inc = true, dec = true;
        int n = nums.length;
        for (int i = 0; i < n - 1; ++i) {
            if (nums[i] > nums[i + 1]) {
                inc = false;
            }
            if (nums[i] < nums[i + 1]) {
                dec = false;
            }
        }
        return inc || dec;
    }

    public static void main(String[] args) {

    }

}
