package programmer.interview.golden.code;

import java.util.Arrays;

/**
 * 判定是否互为字符重排
 *
 */
public class Solution2 {

    public boolean CheckPermutation(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        return Arrays.equals(c1, c2);
    }

}
