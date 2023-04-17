package programmer.interview.golden.code;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 求和路径
 */
public class Solution27 {

    int ans = 0;

    public int pathSum(TreeNode root, int sum) {
        if (root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Queue<TreeNode> cache = new LinkedList<>(queue);
            queue.clear();
            while (!cache.isEmpty()) {
                TreeNode node = cache.poll();
                dfs(node, 0, sum);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return ans;
    }

    private void dfs(TreeNode node, int now, int aim) {
        if (node == null) return;
        if (now + node.val == aim) ans++;
        dfs(node.left, now + node.val, aim);
        dfs(node.right, now + node.val, aim);
    }


    public int pathSum1(TreeNode root, int sum) {
        if (root == null) return 0;
        int ans = rootSum(root, sum);
        ans += pathSum1(root.left, sum);
        ans += pathSum1(root.right, sum);
        return ans;
    }

    public int rootSum(TreeNode root, int sum) {
        int ret = 0;

        if (root == null) {
            return 0;
        }
        int val = root.val;
        if (val == sum) {
            ret++;
        }

        ret += rootSum(root.left, sum - val);
        ret += rootSum(root.right, sum - val);
        return ret;
    }

}
