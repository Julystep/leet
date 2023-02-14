package practice;

import java.util.Stack;

/**
 * 字符串解码
 */
public class Solution394 {

    public String decodeString(String s) {

        StringBuilder ans = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ']') {
                StringBuilder item = new StringBuilder();
                while (!stack.isEmpty() && stack.peek() != '[') {
                    item.insert(0, stack.pop());
                }
                stack.pop();
                StringBuilder timeStr = new StringBuilder();
                while (!stack.isEmpty() && stack.peek() >= '0' && stack.peek() <= '9') {
                    timeStr.insert(0, stack.pop());
                }
                int times = Integer.parseInt(timeStr.toString());
                if (!stack.isEmpty()) {
                    for (int t = 0; t < times; t++) {
                        for (int j = 0; j < item.length(); j++) {
                            stack.push(item.charAt(j));
                        }
                    }
                } else {
                    for (int t = 0; t < times; t ++) {
                        ans.append(item);
                    }
                }
            } else if (s.charAt(i) >= '0' && s.charAt(i) <= '9' || !stack.isEmpty()) {
                stack.push(s.charAt(i));
            } else {
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        Solution394 solution394 = new Solution394();
        solution394.decodeString("3[a]23[bc]");
    }

}
