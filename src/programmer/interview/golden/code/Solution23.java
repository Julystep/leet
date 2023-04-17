package programmer.interview.golden.code;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 合法二叉搜索树
 */
public class Solution23 {

    double value = -Double.MAX_VALUE;
    boolean isTree = true;

    public boolean isValidBST(TreeNode root) {
        midTrans(root);
        return isTree;
    }

    private void midTrans(TreeNode root) {
        if (root == null) return;
        midTrans(root.left);
        if (value >= root.val) isTree = false;
        value = root.val;
        midTrans(root.right);
    }



    public boolean isValidBST2(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        double inorder = -Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
            if (root.val <= inorder) {
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }

}
