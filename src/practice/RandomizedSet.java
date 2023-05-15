package practice;

import java.util.*;

/**
 * hash表查询数据的时间是o1
 * 数组不遍历操作也是o1
 */

public class RandomizedSet {

    List<Integer> numData;
    Map<Integer, Integer> map;
    Random random;
    public RandomizedSet() {
        numData = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        int index = numData.size();
        numData.add(index, val);
        map.put(val, index);
        return true;
    }

    /*
    if (!map.containsKey(val)) return false;
        int index = map.get(val);
        int last = numData.get(numData.size() - 1);
        numData.set(index, last);
        map.put(last, index);
        numData.remove(numData.size() - 1);
        map.remove(val);
        return true;
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int index = numData.size() - 1;
        int loc = map.remove(val);
        if (loc != index) map.put(numData.get(index), loc);
        numData.set(loc, numData.get(index));
        numData.remove(index);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        return numData.get(random.nextInt(numData.size()));
    }

}
