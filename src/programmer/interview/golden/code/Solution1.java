package programmer.interview.golden.code;

import java.util.HashSet;
import java.util.Set;

/**
 * 面试题 01.01. 判定字符是否唯一
 *
 */
public class Solution1 {

    public boolean isUnique(String astr) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < astr.length(); i++) {
            if (!set.add(astr.charAt(i))) return false;
        }
        return true;
    }

}
