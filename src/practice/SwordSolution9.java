package practice;

import java.util.*;

/**
 * 用两个栈实现一个队列
 */
public class SwordSolution9 {

    Deque<Integer> inStack;
    Deque<Integer> outStack;

    public SwordSolution9() {
        inStack = new ArrayDeque<>();
        outStack = new ArrayDeque<>();
    }

    public void appendTail(int value) {
        inStack.push(value);
    }

    public int deleteHead() {
        if (outStack.isEmpty()) {
            if (inStack.isEmpty()) {
                return -1;
            }
            in2out();
        }
        return outStack.pop();
    }

    private void in2out() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }

}
