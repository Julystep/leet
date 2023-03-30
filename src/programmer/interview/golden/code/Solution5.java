package programmer.interview.golden.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 一次编辑
 *
 */
public class Solution5 {

    public boolean oneEditAway(String a, String b) {
        int m = a.length(), n = b.length();
        if (Math.abs(m - n) > 1) return false;
        if (n > m) return oneEditAway(b, a);
        int i = 0, j = 0, flag = 0;
        while(i < m && j < n) {
            char ca = a.charAt(i);
            char cb = b.charAt(j);
            if (ca == cb) {
                i++;
                j++;
            } else {
                if (n == m) {
                    j++;
                }
                i++;
                flag += 1;
            }
        }
        return flag <= 1;
    }

}
