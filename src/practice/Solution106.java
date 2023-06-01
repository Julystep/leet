package practice;

import java.util.HashMap;
import java.util.Map;

/**
 * 从中序与后序遍历序列构造二叉树
 */
public class Solution106 {

    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return myBuildTree(inorder, postorder, 0, n-1, 0, n-1);

    }

    private TreeNode myBuildTree(int[] inorder, int[] postorder, int inLeft, int inRight, int pLeft, int pRight) {

        if (pLeft > pRight || inLeft > inRight) return null;
        TreeNode root = new TreeNode(postorder[pRight]);
        int index = map.get(root.val);
        int len = inRight - index;
        // 0, 0, 1, 3
        root.right = myBuildTree(inorder, postorder, index + 1, inRight, pRight - len, pRight - 1);
        // 2, 4, 0, 0
        root.left = myBuildTree(inorder, postorder, inLeft, index - 1, pLeft, pRight - 1 - len);
        return root;

    }

}
