package practice;

import java.util.ArrayList;
import java.util.List;

/**
 * N 叉树的前序遍历
 */
public class Solution589 {

    public List<Integer> preorder(Node root) {
        if (root == null) return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        traverseTree(root, ans);
        return ans;
    }

    private void traverseTree(Node node, List<Integer> list) {
        if (node == null) return;
        list.add(node.val);
        for (int i = 0; i < node.children.size(); i++) {
            traverseTree(node.children.get(i), list);
        }
    }

}
