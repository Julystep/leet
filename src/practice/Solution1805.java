package practice;

import java.util.HashSet;
import java.util.Set;

/**
 * 字符串中不同整数的数目
 */
public class Solution1805 {

    public int numDifferentIntegers(String word) {
        Set<String> s = new HashSet<>();
        int n = word.length();
        for (int i = 0; i < n; ++i) {
            if (Character.isDigit(word.charAt(i))) {
                while (i < n && word.charAt(i) == '0') {
                    ++i;
                }
                int j = i;
                while (j < n && Character.isDigit(word.charAt(j))) {
                    ++j;
                }
                s.add(word.substring(i, j));
                i = j;
            }
        }
        return s.size();
    }

    public static void main(String[] args) {
        Solution1805 solution1805 = new Solution1805();
        solution1805.numDifferentIntegers("a123bc34d8ef34");
    }

}
