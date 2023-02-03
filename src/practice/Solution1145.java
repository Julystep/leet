package practice;

/**
 * 二叉树着色游戏
 */
public class Solution1145 {

    /*
      找规律
     */

    TreeNode xNode;

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {

        findX(root, x);
        int leftNumber = getSubTree(root.left);
        if (leftNumber > (n + 1) / 2) return true;
        int rightNumber = getSubTree(root.right);
        if (rightNumber > (n + 1) / 2) return true;
        int remain = n - 1 - leftNumber - rightNumber;
        return remain > (n + 1) / 2;

    }

    private int getSubTree(TreeNode node) {
        if (node == null) return 0;
        return 1 + getSubTree(node.left) + getSubTree(node.right);
    }

    private void findX(TreeNode node, int x) {
        if (node == null) return;
        if (node.val == x) {
            xNode = node;
            return;
        }
        findX(node.left, x);
        findX(node.right, x);
    }

}
