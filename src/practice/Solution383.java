package practice;

import java.util.HashMap;
import java.util.Map;

/**
 * 赎金信
 */
public class Solution383 {

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            map.putIfAbsent(magazine.charAt(i), 0);
            map.put(magazine.charAt(i), map.get(magazine.charAt(i)) + 1);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            int times = map.getOrDefault(ransomNote.charAt(i), 0);
            if (times == 0) return false;
            else  map.put(ransomNote.charAt(i), map.get(ransomNote.charAt(i)) - 1);
        }
        return true;
    }

    public boolean canConstruct1(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;
        int[] cnt = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            cnt[magazine.charAt(i) - 'a'] ++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            cnt[ransomNote.charAt(i) - 'a'] --;
            if (cnt[ransomNote.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

}
