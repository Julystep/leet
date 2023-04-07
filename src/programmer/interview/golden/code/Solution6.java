package programmer.interview.golden.code;

import java.util.Objects;
import java.util.Stack;

/**
 * 字符串压缩
 *
 */
public class Solution6 {

    public String compressString(String s) {
        if (Objects.equals(s, "")) return s;
        StringBuilder builder = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty() || stack.peek() == s.charAt(i)) {
                stack.push(s.charAt(i));
            } else if (stack.peek() != s.charAt(i)) {
                builder.append(stack.peek());
                int num = 0;
                while (!stack.isEmpty()) {
                    num ++;
                    stack.pop();
                }
                builder.append(num);
                stack.push(s.charAt(i));
            }
        }
        int num = 0;
        builder.append(stack.peek());
        while (!stack.isEmpty()) {
            num ++;
            stack.pop();
        }
        builder.append(num);
        return builder.toString().length() >= s.length() ? s : builder.toString();
    }

    public String compressString1(String s) {
        if (Objects.equals(s, "")) return s;
        StringBuilder builder = new StringBuilder();
        char c = s.charAt(0);
        int count  = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                count++;
            }
            else {
                builder.append(c);
                builder.append(count);
                c = s.charAt(i);
                count = 1;
            }
        }
        builder.append(c);
        builder.append(count);
        return builder.toString().length() >= s.length() ? s : builder.toString();
    }

    public static void main(String[] args) {
        String s = "aabcccccaa";
        Solution6 solution6 = new Solution6();
        solution6.compressString(s);
    }

}
