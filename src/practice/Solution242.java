package practice;

/**
 * 有效的字母异位词
 */
public class Solution242 {

    public boolean isAnagram(String s, String t) {
        int[] code = new int[26];
        for (int i = 0; i < s.length(); i++) {
            code[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            code[t.charAt(i) - 'a'] --;
        }
        for (int i = 0; i < 26; i++) {
            if (code[i] != 0) return false;
        }
        return true;
    }

}
