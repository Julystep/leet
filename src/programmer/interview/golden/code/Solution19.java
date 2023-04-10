package programmer.interview.golden.code;

import java.util.*;

/**
 * 节点间通路
 */
public class Solution19 {

    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] p : graph){
            if(!map.containsKey(p[0])){
                map.put(p[0],new ArrayList<>()); //新节点得先初始化链表
            }
            map.get(p[0]).add(p[1]);
        }
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(start);
        while(!queue.isEmpty()){
            int temp = queue.pop();
            if(temp == target)
                return true;
            List<Integer> list = map.get(temp);
            if(list == null)    continue;
            queue.addAll(list);
        }
        return false;
    }

}
