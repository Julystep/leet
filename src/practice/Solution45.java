package practice;

/**
 * 从后向前动态规划，每次都找出来距离目标点最远的跳跃节点即可
 */

public class Solution45 {

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

}
