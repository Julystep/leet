package practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * hash
 */
public class Solution1346 {

    public boolean checkIfExist(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i ++) {
            if (map.containsKey(arr[i])) {
                return true;
            }
            map.put(2 * arr[i], i);
        }
        map.clear();
        for (int i = arr.length - 1; i >= 0; i --) {
            if (map.containsKey(arr[i])) {
                return true;
            }
            map.put(2 * arr[i], i);
        }
        return false;
    }

}


