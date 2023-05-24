package practice;

import java.util.HashSet;
import java.util.Objects;

/**
 * 无重复字符的最长子串
 */
public class Solution3 {

    // abcaefghijklmnopq
    public int lengthOfLongestSubstring(String s) {
        if (Objects.equals(s, "")) return 0;
        int l = 0, r = 0;
        int ans = 0;
        HashSet<Character> set = new HashSet<>();
        while (r < s.length()) {
            if (set.add(s.charAt(r))) {
                ans = Math.max(ans, r - l + 1);
                r++;
            } else {
                while (s.charAt(l) != s.charAt(r)) {
                    set.remove(s.charAt(l++));
                }
                set.remove(s.charAt(l++));
            }
        }
        return ans;
    }

}
