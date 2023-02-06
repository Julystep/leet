package practice;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长回文串
 */
public class Solution409 {

    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) map.put(s.charAt(i), 0);
            map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
        }
        int ans = 0;
        int flag = 0;
        for (Integer x : map.values()) {
            ans += (x / 2) * 2;
            if (x % 2 != 0) flag = 1;
        }
        return ans + flag;
    }

}
