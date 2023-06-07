package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉搜索树迭代器
 */
public class BSTIterator {

    // 以下为常规思路
//    Integer index = 0;
//    List<Integer> nums = new ArrayList<>();
//
//    public BSTIterator(TreeNode root) {
//        initNums(root);
//    }
//
//    private void initNums(TreeNode node) {
//        if (node == null) return;
//        initNums(node.left);
//        nums.add(node.val);
//        initNums(node.right);
//    }
//
//    public int next() {
//        return nums.get(index ++);
//    }
//
//    public boolean hasNext() {
//        return index < nums.size();
//    }


    TreeNode cur;
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        cur = root;
        stack = new Stack<>();
    }

    public int next() {
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }

        cur = stack.pop();
        int ret = cur.val;
        cur = cur.right;
        return ret;
    }

    public boolean hasNext() {
        return cur != null || !stack.isEmpty();
    }
}
