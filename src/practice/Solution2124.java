package practice;

/**
 * 检查是否所有 A 都在 B 之前
 */
public class Solution2124 {

    public boolean checkString(String s) {
        int aFirst = -1,  bFirst = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'b' && bFirst == -1) bFirst = i;
            if (s.charAt(i) == 'a') aFirst = i;
        }
        return aFirst > bFirst && bFirst == -1 || aFirst < bFirst;
    }

    public boolean checkString1(String s) {
        int aLast = -1,  bFirst = s.length();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'b') bFirst = Math.min(bFirst, i);
            if (s.charAt(i) == 'a') aLast = Math.max(aLast, i);
        }
        return aLast < bFirst;
    }

}
