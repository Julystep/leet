package practice;

import java.util.*;

/**
 * 删除子文件夹
 */
public class Solution1233 {

    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder, (o1, o2) -> {
            if (o1.length() > o2.length()) return 1;
            else if (o1.length() < o2.length()) return -1;
            return 0;
        });
        List<String> ans = new ArrayList<>();
        for (String item : folder) {
            ans.add(item);
            for (int i = 0; i < ans.size() - 1; i ++) {
                String fold = ans.get(i) + '/';
                if (item.startsWith(fold)) ans.remove(item);
            }
        }
        return ans;
    }

}
