package practice;

import java.util.*;

public class Solution17 {
    /**
     * 工地基础版，无任何高端添加剂
     * @param digits 数组
     * @return 返回数组
     */
    public List<String> letterCombinations(String digits) {
        // 组装一个map
        Map<Character, List<Character>> map = new HashMap<>();
        map.put('2', new ArrayList<>(Arrays.asList('a', 'b', 'c')));
        map.put('3', new ArrayList<>(Arrays.asList('d', 'e', 'f')));
        map.put('4', new ArrayList<>(Arrays.asList('g', 'h', 'i')));
        map.put('5', new ArrayList<>(Arrays.asList('j', 'k', 'l')));
        map.put('6', new ArrayList<>(Arrays.asList('m', 'n', 'o')));
        map.put('7', new ArrayList<>(Arrays.asList('p', 'q', 'r', 's')));
        map.put('8', new ArrayList<>(Arrays.asList('t', 'u', 'v')));
        map.put('9', new ArrayList<>(Arrays.asList('w', 'x', 'y', 'z')));

        List<String> ans = new ArrayList<>();
        int len = digits.length();
        if (len == 0) return ans;
        dfs(ans, digits, 0, "", len, map);
        return ans;
    }

    private void dfs(List<String> ans, String digits, int index, String str, int len, Map<Character, List<Character>> map) {

        if (index == len) {
            ans.add(str);
            return;
        }
        List<Character> list = map.get(digits.charAt(index));
        for (Character c : list) {
            dfs(ans, digits, index + 1, str + c, len, map);
        }

    }

    public static void main(String[] args) {
        Solution17 solution17 = new Solution17();
        System.out.println(solution17.letterCombinations("23"));
    }

}
