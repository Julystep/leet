package programmer.interview.golden.code;

import java.util.Stack;

/**
 * 栈排序
 */
public class SortedStack {

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public SortedStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int val) {
        if (stack1.isEmpty()) {
            stack1.push(val);
            return;
        }
        while(!stack1.isEmpty() && stack1.peek() < val){
            stack2.push(stack1.pop());
        }
        stack1.push(val);
        // 将暂时存储到 辅助栈temp中的所有元素移动到主栈中;
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
    }

    public void pop() {
        if (!stack1.isEmpty()) {
            stack1.pop();
        }
    }

    public int peek() {
        return stack1.isEmpty() ? -1 : stack1.peek();
    }

    public boolean isEmpty() {
        return stack1.isEmpty();
    }

}
