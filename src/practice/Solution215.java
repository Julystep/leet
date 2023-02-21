package practice;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 数组中的第K个最大元素
 */
public class Solution215 {

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k + 1];
    }

    public int findKthLargest1(int[] nums, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<>((n1, n2) -> n2 - n1);
        for (int num : nums) queue.offer(num);
        for (int i = 0; i < k - 1; i++) {
            queue.poll();
        }
        return queue.poll();
    }

}
