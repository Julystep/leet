package practice;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字转整数
 */
public class Solution13 {

    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int number = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char item = s.charAt(i);
            if (i < s.length() - 1 && map.get(s.charAt(i + 1)) > map.get(item)) number -= map.get(item);
            else number += map.get(item);
        }
        return number;
    }

}
