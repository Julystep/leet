package practice;

import java.util.*;

/**
 * 串联所有单词的子串
 */
public class Solution30 {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        int wordLen = words[0].length();
        int len = wordLen * words.length;
        int l = 0;
        Arrays.sort(words);
        while (l + len <= s.length()) {
            String x = s.substring(l, l + len);
            String[] xs = new String[words.length];
            for (int i = 0; i * wordLen < len; i++) {
                xs[i] = x.substring(i * wordLen,(i+1) * wordLen);
            }
            Arrays.sort(xs);
            ans.add(l);
            for (int i = 0; i < words.length; i++) {
                if (!Objects.equals(xs[i], words[i])) {
                    ans.remove(ans.size() - 1);
                    break;
                }
            }
            l++;
        }
        return ans;
    }

    public List<Integer> findSubstring1(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        int m = words.length, n = words[0].length(), ls = s.length();
        for (int i = 0; i < n; i++) {
            if (i + m * n > ls) {
                break;
            }
            Map<String, Integer> differ = new HashMap<String, Integer>();
            for (int j = 0; j < m; j++) {
                String word = s.substring(i + j * n, i + (j + 1) * n);
                differ.put(word, differ.getOrDefault(word, 0) + 1);
            }
            for (String word : words) {
                differ.put(word, differ.getOrDefault(word, 0) - 1);
                if (differ.get(word) == 0) {
                    differ.remove(word);
                }
            }
            for (int start = i; start < ls - m * n + 1; start += n) {
                if (start != i) {
                    String word = s.substring(start + (m - 1) * n, start + m * n);
                    differ.put(word, differ.getOrDefault(word, 0) + 1);
                    if (differ.get(word) == 0) {
                        differ.remove(word);
                    }
                    word = s.substring(start - n, start);
                    differ.put(word, differ.getOrDefault(word, 0) - 1);
                    if (differ.get(word) == 0) {
                        differ.remove(word);
                    }
                }
                if (differ.isEmpty()) {
                    res.add(start);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution30 solution30 = new Solution30();
        String[] x = {"word","good","best","good"};
        System.out.println(solution30.findSubstring("wordgoodgoodgoodbestword", x));
//        String x = "barfoo";
//        System.out.println(x.substring(3, 6));
    }

}
