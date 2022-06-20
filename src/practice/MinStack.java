package practice;

import java.util.Objects;
import java.util.Stack;

/**
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 *
 */
public class MinStack {

    Stack<Integer> A;
    Stack<Integer> B;

    public MinStack() {
        A = new Stack<>();
        B = new Stack<>();
    }

    public void push(int x) {
        A.add(x);
        if (B.isEmpty() || x <= B.peek()) B.push(x);
    }

    public void pop() {
        if (!B.isEmpty() && Objects.equals(A.peek(), B.peek())) B.pop();
        A.pop();
    }

    public int top() {
        return A.peek();
    }

    public int min() {
        return B.peek();
    }

}
