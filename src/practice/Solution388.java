package practice;

import java.util.List;
import java.util.Stack;
/**
 * 用栈来解决
 */
public class Solution388 {

    public int lengthLongestPath(String input) {
        Stack<String> stack = new Stack<>();
        int length = 0;
        String[] split = input.split("\n");
        int ans = 0;
        for (int i = 0; i < split.length; i++) {
            if (stack.size() == 0) {
                stack.push(split[i]);
                length += split[i].length();
            } else {
                while (stack.size() > 0 && stack.peek().lastIndexOf("\t") >= split[i].lastIndexOf("\t")) {
                    String num = stack.pop();
                    length = length - num.length() + num.lastIndexOf("\t");
                }
                stack.push(split[i]);
                length += split[i].length() - split[i].lastIndexOf("\t");
            }
            if (split[i].contains(".")) {
                ans = Math.max(ans, length);
            }
        }
        return ans;
    }

}
