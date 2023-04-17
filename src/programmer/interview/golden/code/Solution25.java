package programmer.interview.golden.code;

/**
 * 首个共同祖先
 */
public class Solution25 {
    TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }
    private boolean dfs(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) return false;
        boolean lson = dfs(node.left, p, q);
        boolean rson = dfs(node.right, p, q);
        if ((lson && rson) || (node.val == p.val || node.val == q.val) && (lson || rson)) {
            ans = node;
        }
        return lson || rson || (node.val == p.val || node.val == q.val);
    }
}
