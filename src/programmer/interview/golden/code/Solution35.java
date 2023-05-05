package programmer.interview.golden.code;

import java.util.ArrayList;
import java.util.List;

/**
 * 无重复字符串的排列组合
 */
public class Solution35 {

    List<String> ans = new ArrayList<>();

    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
        List<Character> road = new ArrayList<>();
        dfs(chars, road);
        return ans.toArray(new String[0]);
    }

    private void dfs(char[] chars, List<Character> road) {

        if (road.size() == chars.length) {
            road.stream().map(String::valueOf).reduce(String::concat).ifPresent(ans::add);
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (road.contains(chars[i])) continue;
            road.add(chars[i]);
            dfs(chars, road);
            road.remove(chars[i]);
        }

    }


    public static void main(String[] args) {
        Solution35 solution35 = new Solution35();
        solution35.permutation("qwe");
    }

}
