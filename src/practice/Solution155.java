import java.util.Objects;
import java.util.Stack;

/**
 * 最小栈
 *
 * @author <a href="mailto:liml28084@hundsun.com">liml28084</a>
 * @since v0.0.0
 * @since 2022/11/9
 */
public class Solution155 {

    Stack<Integer> stack;
    Stack<Integer> minStack;

    public Solution155() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || minStack.peek() >= val) minStack.push(val);
    }

    public void pop() {
        if (Objects.equals(minStack.peek(), stack.pop())) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        if (minStack.isEmpty()) return 0;
        return minStack.peek();
    }

    public static void main(String[] args) {

//        Solution155 solution155 = new Solution155();
//        solution155.push(512);
//        solution155.push(-1024);
//        solution155.push(-1024);
//        solution155.push(512);
//        solution155.pop();
//        solution155.getMin();
//        solution155.pop();
//        solution155.getMin();
//        solution155.pop();
//        solution155.getMin();

        Integer x = -1024;
        Integer y = -1024;
        if (x.equals(y)) System.out.println("1");
        if (x.intValue() == y.intValue()) System.out.println("2");

    }

}
