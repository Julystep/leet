package practice;

import java.util.HashMap;
import java.util.Map;

public class Solution205 {

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) map.put(s.charAt(i), t.charAt(i));
            else if (map.get(s.charAt(i)) != t.charAt(i)) return false;

            if (!map2.containsKey(t.charAt(i))) map2.put(t.charAt(i), s.charAt(i));
            else if (map2.get(t.charAt(i)) != s.charAt(i)) return false;
        }
        return true;
    }

}
