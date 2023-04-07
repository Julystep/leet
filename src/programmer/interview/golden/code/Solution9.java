package programmer.interview.golden.code;

import java.util.Objects;

/**
 * 字符串轮转
 */
public class Solution9 {

    public boolean isFlipedString(String s1, String s2) {
        return s1.length() == s2.length() && (s1 + s1).contains(s2);
    }

    public static void main(String[] args) {
        String x = "123456789";
        System.out.println(x.substring(0, 8));
    }

}
