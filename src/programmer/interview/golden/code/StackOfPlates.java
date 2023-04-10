package programmer.interview.golden.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 堆盘子
 */
public class StackOfPlates {

//    List<Stack<Integer>> stacks = new ArrayList<>();
//    int cap;
//
//    public StackOfPlates(int cap) {
//        this.cap = cap;
//        Stack<Integer> stack = new Stack<>();
//        stacks.add(stack);
//    }
//
//    public void push(int val) {
//        if (cap == 0) {
//            return;
//        }
//        // 栈的个数，找最后一个栈，看是否已满
//        int stacksSize = stacks.size();
//        // 最后一个栈
//        Stack<Integer> lastStack = stacks.get(stacksSize - 1);
//        if (lastStack.size() == cap) { // 栈已满，开新栈
//            Stack<Integer> stack = new Stack<>();
//            stack.push(val);
//            stacks.add(stack);
//        } else {
//            lastStack.push(val);
//        }
//    }
//
//    public int pop() {
//        // 弹出最后一个栈的首值
//        return popAt(stacks.size() - 1);
//    }
//
//    public int popAt(int index) {
//        if (cap == 0) {
//            return -1;
//        }
//        int stacksSize = stacks.size();
//        if (index >= stacksSize) {
//            return -1;
//        }
//        Stack<Integer> indexStack = stacks.get(index);
//        int size = indexStack.size();
//        if (size == 1) {
//            int res = indexStack.pop();
//            // 栈的总数大于1才删除，即默认保留一个空栈
//            if (stacksSize > 1) {
//                stacks.remove(index);
//            }
//            return res;
//        } else if (size > 0) {
//            return indexStack.pop();
//        } else {
//            return -1;
//        }
//    }

    List<Stack<Integer>> list;
    int size;
    int cap;

    public StackOfPlates(int cap) {
        list = new ArrayList<>();
        size = 0;
        this.cap = cap;
    }

    public void push(int val) {
        if (cap == 0) return;
        if (size == 0 || list.get(size - 1).size() == cap) {
            list.add(new Stack<>());
            size++;
        }
        list.get(size - 1).push(val);
    }

    public int pop() {
        if (size == 0 || cap == 0) return -1;
        return valueGet(size - 1);
    }

    public int popAt(int index) {
        if (size - 1 < index || cap == 0) return -1;
        return valueGet(index);
    }

    private int valueGet(int index) {
        if (list.isEmpty()) return -1;
        Stack<Integer> stack = list.get(index);
        int ans = stack.pop();
        if (stack.isEmpty()) {
            list.remove(index);
            size--;
        }
        return ans;
    }

}
