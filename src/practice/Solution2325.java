package practice;

import java.util.HashMap;
import java.util.Map;

/**
 * 解密消息
 */
public class Solution2325 {

    public String decodeMessage(String key, String message) {
        Map<Character, Character> dictionary = createDictionary(key);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            builder.append(dictionary.get(message.charAt(i)));
        }
        return builder.toString();
    }

    private Map<Character, Character> createDictionary(String key) {
        int first = 'a' - 1;
        Map<Character, Character> ans = new HashMap<>();
        ans.put(' ', ' ');
        for (int i = 0; i < key.length(); i++) {
            if (!ans.containsKey(key.charAt(i))) {
                ans.put(key.charAt(i), (char) (first + 1));
                first = first + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String key = "the quick brown fox jumps over the lazy dog";
        String message = "vkbs bs t suepuv";
        Solution2325 solution2325 = new Solution2325();
        System.out.println(solution2325.decodeMessage(key, message));
    }

}
