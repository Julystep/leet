package practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 单词规律
 */
public class Solution290 {

    public boolean wordPattern(String pattern, String s) {
        Map<String, String> map1 = new HashMap<>();
        String[] ss = s.split(" ");
        if (pattern.length() != ss.length) return false;
        for (int i = 0; i < pattern.length(); i++) {
            String key = String.valueOf(pattern.charAt(i));
            if (map1.containsKey(key) && !Objects.equals(map1.get(key), ss[i]) || !map1.containsKey(key) && map1.containsValue(ss[i])) return false;
            map1.put(key, ss[i]);
        }
        return true;
    }

}
