package practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 检查相同字母间的距离
 */
public class Solution2399 {

    public boolean checkDistances(String s, int[] distance) {
        int[] flag = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if (flag[c] > 0 && i - flag[c] != distance[c]) return false;
            flag[c] = i + 1;

        }
        return true;
    }

    public static void main(String[] args) {
        Solution2399 solution2399 = new Solution2399();
        solution2399.checkDistances("abaccb", new int[]{1,3,0,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
    }

}
