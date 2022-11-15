import java.util.Objects;
import java.util.Stack;

/**
 * 有效的括号
 *
 * @author <a href="mailto:liml28084@hundsun.com">liml28084</a>
 * @since v0.0.0
 * @since 2022/11/9
 */
public class Solution20 {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }
            if (Objects.equals(c, '}') && Objects.equals(stack.peek(), '{')
                    || Objects.equals(c, ']') && Objects.equals(stack.peek(), '[')
                    || Objects.equals(c, ')') && Objects.equals(stack.peek(), '(')) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution20 solution20 = new Solution20();
        solution20.isValid("()");
    }

}
