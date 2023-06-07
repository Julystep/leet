package practice;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树的最近公共祖先
 */
public class Solution236 {

    private TreeNode ans = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);
        if (lson && rson || (root.val == p.val || root.val == q.val) && (lson || rson)) {
            ans = root;
        }
        return lson || rson || root.val == p.val || root.val == q.val;
    }
}
