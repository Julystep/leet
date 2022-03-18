package swordfingeroffer.day1;

import java.util.Stack;

// 利用栈实现队列

public class CQueue {

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        int value = stack2.isEmpty() ? -1 : stack2.pop();
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return value;
    }

}
