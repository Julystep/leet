package practice;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 警告一小时内使用相同员工卡大于等于三次的人
 */
public class Solution1604 {

    public List<String> alertNames1(String[] keyName, String[] keyTime) {
        Map<String, List<Integer>> timeInterval = new HashMap<>();
        Map<String, String> newestMap = new HashMap<>();
        for (int i = 0; i < keyName.length; i++) {
            if (!newestMap.containsKey(keyName[i])) {
                timeInterval.put(keyName[i], new ArrayList<>(Collections.singletonList(0)));
            } else {
                timeInterval.get(keyName[i]).add(calTimeInterval(newestMap.get(keyName[i]), keyTime[i]));
            }
            newestMap.put(keyName[i], keyTime[i]);
        }
        Set<String> cache = new HashSet<>();
        for (String key : timeInterval.keySet()) {
            List<Integer> item = timeInterval.get(key);
            if (item.size() < 3) continue;
            int time = item.get(item.size() - 1) + item.get(item.size() - 2);
            for (int i = item.size() - 3; i >= 0; i--) {
                if (time + item.get(i) <= 60 && time + item.get(i) >= 0) cache.add(key);
                else time -= item.get(i + 2);
            }
        }
        List<String> ans = new ArrayList<>(cache);
        Collections.sort(ans);
        return ans;
    }

    private Integer calTimeInterval(String before, String after) {
        List<Integer> befores = Arrays.stream(before.split(":")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> afters = Arrays.stream(after.split(":")).map(Integer::parseInt).collect(Collectors.toList());
        if (afters.get(0) < befores.get(0)) {
            return 200 + afters.get(0) * 60 + afters.get(1) - befores.get(1);
        } else {
            return (afters.get(0) - befores.get(0)) * 60 + afters.get(1) - befores.get(1);
        }
    }

    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, List<Integer>> timeMap = new HashMap<>();
        int n = keyName.length;
        for (int i = 0; i < n; i++) {
            String name = keyName[i];
            String time = keyTime[i];
            timeMap.putIfAbsent(name, new ArrayList<>());
            int hour = (time.charAt(0) - '0') * 10 + (time.charAt(1) - '0');
            int minute = (time.charAt(3) - '0') * 10 + (time.charAt(4) - '0');
            timeMap.get(name).add(hour * 60 + minute);
        }
        List<String> res = new ArrayList<>();
        Set<String> keySet = timeMap.keySet();
        for (String name : keySet) {
            List<Integer> list = timeMap.get(name);
            Collections.sort(list);
            int size = list.size();
            for (int i = 2; i < size; i++) {
                int time1 = list.get(i - 2), time2 = list.get(i);
                int difference = time2 - time1;
                if (difference <= 60) {
                    res.add(name);
                    break;
                }
            }
        }
        Collections.sort(res);
        return res;
    }

    public static void main(String[] args) {
        String[] keyName = new String[]{"a","a","a","a", "a","a"};
        String[] keyTime = new String[]{"23:27","03:14","12:57","13:35", "03:15", "03:16"};
        Solution1604 solution1604 = new Solution1604();
        solution1604.alertNames(keyName, keyTime);
    }


}
