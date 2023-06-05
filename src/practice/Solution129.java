package practice;

import java.util.ArrayList;
import java.util.List;

/**
 * 求根节点到叶节点数字之和
 */
public class Solution129 {

    List<Integer> numbers = new ArrayList<>();

    public int sumNumbers(TreeNode root) {

        int ans = 0;
        findNumber(root, 0);
        for (Integer number : numbers) {
            ans += number;
        }
        return ans;

    }

    private void findNumber(TreeNode root, Integer num) {
        if (root == null) return;
        num = num * 10 + root.val;
        if (root.left == null && root.right == null) {
            numbers.add(num);
            return;
        }
        findNumber(root.left, num);
        findNumber(root.right, num);
    }

}
