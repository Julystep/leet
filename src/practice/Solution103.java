package practice;

import java.util.*;

/**
 * 二叉树的锯齿形层序遍历
 */
public class Solution103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        List<TreeNode> cache = new ArrayList<>();
        cache.add(root);
        int direct = 0;
        while(!cache.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            Collections.reverse(cache);
            Queue<TreeNode> queue = new ArrayDeque<>(cache);
            cache.clear();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (direct == 1) {
                    if (Objects.nonNull(node.right)) cache.add(node.right);
                    if (Objects.nonNull(node.left)) cache.add(node.left);
                } else {
                    if (Objects.nonNull(node.left)) cache.add(node.left);
                    if (Objects.nonNull(node.right)) cache.add(node.right);
                }
            }
            ans.add(list);
            direct = 1 - direct;
        }
        return ans;
    }

}
