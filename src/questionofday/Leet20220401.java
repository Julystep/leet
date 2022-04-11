package questionofday;

import java.util.*;
import java.util.stream.Collectors;

public class Leet20220401 {

    public boolean canReorderDoubled(int[] arr) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(Math::abs));
        Arrays.stream(arr).forEach(queue::add);
        Map<Integer, Integer> hashMap = new HashMap<>();
        while (!queue.isEmpty()) {
            Integer first  = queue.poll();
            if (hashMap.containsKey(first) && hashMap.get(first) > 0) {
                hashMap.put(first, hashMap.get(first) - 1);
            } else {
                hashMap.put(2 * first, hashMap.containsKey(2 * first) ? hashMap.get(2 * first) + 1 : 1);
            }
        }
        for (Integer val : hashMap.values()) {
            if (val != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] a = {2,1,2,1,1,1,2,2};
        System.out.println(new Leet20220401().canReorderDoubled(a));
    }

}
