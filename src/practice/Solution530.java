package practice;

/**
 * 二叉搜索树的最小绝对差
 */
public class Solution530 {

    int ans = Integer.MAX_VALUE;
    int pre = -1;

    public int getMinimumDifference(TreeNode root) {
        checkNode(root);
        return ans;
    }

    private void checkNode(TreeNode root) {

        if (root == null) return;
        checkNode(root.left);
        if (pre != -1) {
            ans = Math.min(ans, root.val - pre);
        }
        pre = root.val;
        checkNode(root.right);
    }

}
