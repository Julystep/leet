package practice;

/**
 * 二叉树的最大深度
 */
public class Solution104 {
    // 层序遍历没啥用
    // 递归
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int left = 0, right = 0;
        if (root.left != null) {
            left = maxDepth(root.left) + 1;
        }
        if (root.right != null) {
            right = maxDepth(root.right) + 1;
        }
        return Math.max(left, right);
    }

}
