package programmer.interview.golden.code;

import java.util.HashSet;
import java.util.Set;

/**
 * 回文排列
 *
 */
public class Solution4 {

    public boolean canPermutePalindrome(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (!set.add(s.charAt(i))) set.remove(s.charAt(i));
        }
        return set.size() <= 1;
    }

}
