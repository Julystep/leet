package practice;

/**
 * 完全二叉树的节点个数
 */
public class Solution222 {

    public int countNodes(TreeNode root) {
        return root == null ? 0 : countNodes(root.left) + countNodes(root.right) + 1;
    }
}
