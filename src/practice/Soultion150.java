import java.util.*;

/**
 * 逆波兰表达式
 *
 * @since 2022/11/16
 */
public class Soultion150 {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (Objects.equals("+", tokens[i])) {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x + y);
            } else if (Objects.equals("-", tokens[i])) {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x - y);
            } else if (Objects.equals("*", tokens[i])) {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x * y);
            } else if (Objects.equals("/", tokens[i])) {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x / y);
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.peek();
    }

    public static void main(String[] args) {
        Soultion150 soultion150 = new Soultion150();
        String[] x = {"4","13","5","/","+"};
        System.out.println(soultion150.evalRPN(x));
    }

}
