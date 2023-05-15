package practice;

/**
 * 接雨水
 *
 */
public class Solution42 {

    public int trap(int[] height) {
        int len = height.length;
        int[] maxLeft = new int[len];
        maxLeft[0] = height[0];
        for (int i = 1; i < len; i++) {
            maxLeft[i] = Math.max(maxLeft[i-1], height[i]);
        }
        int[] maxRight = new int[len];
        maxRight[len-1] = height[len-1];
        for (int i = len - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i+1], height[i]);
        }
        int ans = 0;
        for (int i = 0; i < len; i++) {
            ans += Math.min(maxLeft[i], maxRight[i]) - height[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution42 solution42 = new Solution42();
        int[] x = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(solution42.trap(x));
    }

}
