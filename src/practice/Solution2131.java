package practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 连接两字母单词得到的最长回文串
 */
public class Solution2131 {

    public int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> equal = new HashMap<>();

        int ans = 0;

        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            sb.append(word);
            String reverse = sb.reverse().toString();

            if (word.equals(reverse)) {
                equal.put(reverse, equal.getOrDefault(reverse, 0) + 1);
                continue;
            }

            if (map.containsKey(reverse)) {
                ans += word.length() * 2;

                if (map.get(reverse) == 1) {
                    map.remove(reverse);
                } else {
                    map.put(reverse, map.get(reverse) - 1);
                }
            } else {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        int max = 0;

        for (Map.Entry<String, Integer> entry : equal.entrySet()) {
            if (entry.getValue() == 1) {
                max = Math.max(max, entry.getKey().length());
            } else {
                if (entry.getValue() % 2 == 1) {
                    ans += (entry.getValue() - 1) * entry.getKey().length();
                    max = Math.max(max, entry.getKey().length());
                } else {
                    ans += entry.getValue() * entry.getKey().length();
                }
            }
        }

        return ans + max;
    }

    public static void main(String[] args) {
        Solution2131 solution2131 = new Solution2131();
        solution2131.longestPalindrome(new String[]{"dd","aa","bb","dd","aa","dd","bb","dd","aa","cc","bb","cc","dd","cc"});
    }

    // "qo","fo","fq","qf","fo","ff","qq","qf","of","of","oo","of","of","qf","qf","of"

    /**
     * dd: 5
     * aa: 3
     * bb: 3
     * cc: 3
     *
     * 8 + 4 + 4 + 4 + 2 =
     *
     */

}
