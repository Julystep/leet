package practice;


public class Solution108 {

    /**
     * 做之前完全没有思路的题目
     * 分治思想
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(0, nums.length - 1, nums);
    }

    private TreeNode helper(int left, int right, int[] nums) {
        if (left > right) return null;
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(left, mid - 1, nums);
        node.right = helper(mid + 1, right, nums);
        return node;
    }

}
