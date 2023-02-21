package practice;

import java.util.*;

/**
 * 前K个高频单词
 */
public class Solution692 {

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (!map.containsKey(word)) map.put(word, 0);
            map.put(word, map.get(word) + 1);
        }
        List<String> ans = new ArrayList<>(map.keySet());
        ans.sort((w1, w2) -> Objects.equals(map.get(w1), map.get(w2)) ? w1.compareTo(w2) : map.get(w2) - map.get(w1));
        return ans.subList(0, k);
    }

}
