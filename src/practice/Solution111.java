package practice;

import java.util.*;

/**
 * 二叉树的最小深度
 */
public class Solution111 {

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int deep = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            deep++;
            // 用一个队列，用于优化内存
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return deep;
                }
                if(Objects.nonNull(node.left)) queue.add(node.left);
                if(Objects.nonNull(node.right)) queue.add(node.right);
            }
        }
        return deep;
    }

}
