import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 二叉树中的链表
 *
 * @since 2022/11/21
 */
public class Solution1367 {

    public boolean isSubPath(ListNode head, TreeNode root) {

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Queue<TreeNode> item = new ArrayDeque<>();
            item.addAll(queue);
            queue.clear();
            for (TreeNode node : item) {
                if (findRoot(node, head)) {
                    return true;
                } else {
                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);
                }
            }
        }
        return false;
    }

    private boolean findRoot(TreeNode tree, ListNode node) {
        if (node == null) return true;
        if (tree == null) return false;
        if (tree.val == node.val) return findRoot(tree.left, node.next) || findRoot(tree.right, node.next);
        return false;
    }

}
