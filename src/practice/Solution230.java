package practice;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 二叉搜索树中第K小的元素
 */
public class Solution230 {

    List<Integer> list = new ArrayList<>();

    public int kthSmallest1(TreeNode root, int k) {
        checkNode(root);
        return list.get(k - 1);
    }

    private void checkNode(TreeNode root) {
        if (root == null) return;
        checkNode(root.left);
        list.add(root.val);
        checkNode(root.right);
    }


    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        while (root != null || !queue.isEmpty()) {
            while (root != null) {
                queue.push(root);
                root = root.left;
            }
            root = queue.pop();
            k--;
            if (k == 0) break;
            root = root.right;
        }
        return root.val;
    }

}
