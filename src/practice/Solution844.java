package practice;

import java.util.Stack;

/**
 * 比较含退格的字符串
 */
public class Solution844 {

    public boolean backspaceCompare(String s, String t) {
        Stack<Character> sStack = new Stack<>();
        Stack<Character> tStack = new Stack<>();
        setStack(s, sStack);
        setStack(t, tStack);
        while (!sStack.isEmpty() && !tStack.isEmpty()) {
            if (sStack.pop() != tStack.pop()) return false;
        }
        return sStack.isEmpty() && tStack.isEmpty();
    }

    public void setStack(String str, Stack<Character> stack) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '#') {
                if (!stack.isEmpty()) stack.pop();
            } else {
                stack.push(str.charAt(i));
            }
        }
    }

    public static void main(String[] args) {
        Solution844 solution844 = new Solution844();
        solution844.backspaceCompare("y#fo##f", "y#f#o##f");
    }

}
