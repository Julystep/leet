package practice;

import java.util.*;

/**
 * 逆波兰表达式求值
 */
public class Solution150 {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (Objects.equals(token, "+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (Objects.equals(token, "-")) {
                stack.push(-(stack.pop() - stack.pop()));
            } else if (Objects.equals(token, "*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (Objects.equals(token, "/")) {
                int x = stack.pop();
                stack.push(stack.pop() / x);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.peek();
    }

}
