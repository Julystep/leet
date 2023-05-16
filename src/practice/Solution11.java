package practice;

/**
 * 盛水最多的容器
 */
public class Solution11 {

    public int maxArea(int[] height) {
        int len = height.length;
        int left = 0, right = len - 1;
        int ans = 0;
        while (left < right) {
            ans = Math.max(Math.min(height[left], height[right]) * (right - left), ans);
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }

}
