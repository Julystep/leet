package practice;

import java.util.*;

/**
 * 二叉树的层序遍历 II
 */
public class Solution107 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (Objects.isNull(root)) return new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        List<List<Integer>> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            // 用一个队列，用于优化内存
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if(Objects.nonNull(node.left)) queue.add(node.left);
                if(Objects.nonNull(node.right)) queue.add(node.right);
            }
            ans.add(0, list);
        }
        return ans;
    }

}
