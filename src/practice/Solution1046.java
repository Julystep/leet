package practice;

import java.util.*;

/**
 * 最后一块石头的重量
 */
public class Solution1046 {

    public int lastStoneWeight(int[] stones) {
        if (stones.length == 1) return stones[0];
        Arrays.sort(stones);
        while (stones[stones.length - 2] != 0) {
            stones[stones.length - 1] = stones[stones.length - 1] - stones[stones.length - 2];
            stones[stones.length - 2] = 0;
            Arrays.sort(stones);
        }
        return stones[stones.length - 1];
    }

    /*
    优先队列，最大堆
     */
    public int lastStoneWeight1(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((s1, s2) -> s2 - s1);
        for (int stone : stones) {
            queue.offer(stone);
        }
        while (queue.size() > 1) {
            int x = queue.poll();
            int y = queue.poll();
            if (x - y != 0) queue.offer(x - y);
        }
        return queue.isEmpty() ? 0 : queue.poll();
    }


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(666);
        list.add(6);
        list.add(2);
        list.add(100);
        list.add(50);
        System.out.println(list);

        list.sort(Comparator.reverseOrder());

        System.out.println(list);

    }

}
