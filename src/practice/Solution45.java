package practice;

/**
 * 从后向前动态规划，每次都找出来距离目标点最远的跳跃节点即可
 */

public class Solution45 {

    /**
     * 倒着查的贪心算法虽然简单，但是时间复杂度还是有点高
     */
    public int jump(int[] nums) {
        int position = nums.length - 1;
        int step = 0;
        while (position > 0) {
            for (int i = 0; i < position; i++) {
                if (position <= nums[i] + i) {
                    position = i;
                    step++;
                    break;
                }
            }
        }
        return step;
    }

    public int jump1(int[] nums) {
        int len = nums.length;
        int end = 0;
        int maxPosition = 0;
        int step = 0;
        for (int i = 0; i < len; i++) {
            maxPosition = Math.max(nums[i] + i, maxPosition);
            if (i == end) {
                end = maxPosition;
                step++;
            }
        }
        return step;
    }

}
