/**
 * 找出字符串中第一个匹配项的下标
 *
 * @since 2022/11/15
 */
public class Solution28 {

    public int strStr(String haystack, String needle) {
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                if (haystack.length() - i < needle.length()) return -1;
                int j = 1;
                for (; j < needle.length(); j ++) {
                    if (haystack.charAt(i+j) != needle.charAt(j)) break;
                }
                if (j == needle.length()) return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution28 solution28 = new Solution28();
        System.out.println(solution28.strStr("sadbutsad", "sad"));
    }

}
