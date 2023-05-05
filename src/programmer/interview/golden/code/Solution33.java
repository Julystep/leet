package programmer.interview.golden.code;

/**
 * 递归乘法
 */
public class Solution33 {

    public int multiply(int A, int B) {
        int min = Math.min(A, B);
        int max = Math.max(A, B);
        int ans = 0;

        for (int i = 0; min != 0; i++) {
            if ((min & 1) == 1) {
                ans += max << i;
            }
            min >>= 1;
        }

        return ans;
    }

}
