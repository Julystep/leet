package practice;

import java.util.HashSet;
import java.util.Set;

/**
 * 拆分字符串使唯一子字符串的数目最大
 */
public class Solution1593 {

    int maxSplit = 1;

    public int maxUniqueSplit(String s) {
        Set<String> set = new HashSet<>();
        backtrack(0, 0, s, set);
        return maxSplit;
    }

    private void backtrack(int index, int split, String s, Set<String> set) {
        int length = s.length();
        if (index >= length) maxSplit = Math.max(maxSplit, split);
        for (int i = index; i < length; i++) {
            if (set.add(s.substring(index, i + 1))) {
                backtrack(i + 1, split + 1, s, set);
                set.remove(s.substring(index, i + 1));
            }
        }
    }


}
