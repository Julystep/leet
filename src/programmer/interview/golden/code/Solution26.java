package programmer.interview.golden.code;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 检查子树
 */
public class Solution26 {

    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        if (t2 == null) return true;
        if (t1 == null) return false;
        return isSameTree(t1, t2) || checkSubTree(t1.left, t2) || checkSubTree(t1.right, t2);
    }

    public boolean isSameTree(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) return true;
        if (n1 == null || n2 == null) return false;
        return n1.val == n2.val && isSameTree(n1.left, n2.left) && isSameTree(n1.right, n2.right);
    }

}
