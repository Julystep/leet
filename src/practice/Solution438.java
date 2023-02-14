package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 找到字符串中所有字母异位词
 */
public class Solution438 {

    /**
     * 时间复杂度不允许
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        List<String> pList = Arrays.stream(p.split("")).sorted().collect(Collectors.toList());
        for (int i = 0; i < s.length(); i++) {
            if (pList.contains(s.substring(i, i + 1))
                    && checkIfSame(s, i, pList)) {
                ans.add(i);
            }
        }
        return ans;
    }

    private boolean checkIfSame(String s, Integer index, List<String> pList) {
        if (index + pList.size() > s.length()) return false;
        List<String> itemList = Arrays.stream(s.substring(index, index + pList.size()).split("")).sorted().collect(Collectors.toList());
        return Objects.equals(String.join("", itemList), String.join("", pList));
    }


    public List<Integer> findAnagrams1(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        List<Integer> ans = new ArrayList<>();
        if (sLen < pLen) return ans;
        int[] sArr = new int[26];
        int[] pArr = new int[26];
        for (int i = 0; i < pLen; i++) {
            ++sArr[s.charAt(i) - 'a'];
            ++pArr[p.charAt(i) - 'a'];
        }
        if (Arrays.equals(sArr, pArr)) {
            ans.add(0);
        }
        for (int i = 0; i < sLen - pLen; i++) {
            --sArr[s.charAt(i) - 'a'];
            ++sArr[s.charAt(i + pLen) - 'a'];
            if (Arrays.equals(sArr, pArr)) {
                ans.add(i + 1);
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        Solution438 solution438 = new Solution438();
        solution438.findAnagrams1("cbaebabacd", "abc");
    }

}
