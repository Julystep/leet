package programmer.interview.golden.code;

import java.util.*;

/**
 * 节点间通路
 */
public class Solution19 {

    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] ints : graph) {
            if (!map.containsKey(ints[0])) {
                map.put(ints[0], new ArrayList<>());
            }
            map.get(ints[0]).add(ints[1]);
        }
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int temp = queue.pop();
            if(temp == target)
                return true;
            List<Integer> list = map.get(temp);
            if(list == null) continue;
            queue.addAll(list);
        }
        return false;
    }

}
