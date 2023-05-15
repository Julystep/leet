package practice;

import java.util.Objects;

/**
 * 反转字符串中的单词
 */
public class Solution151 {

    public String reverseWords(String s) {
        String[] words = s.trim().split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            if (!Objects.equals(words[i], "")) {
                builder.append(words[i]).append(" ");
            }
        }
        return builder.toString().trim();
    }

}
