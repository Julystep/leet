package programmer.interview.golden.code;

/**
 * URL化
 *
 */
public class Solution3 {

    public String replaceSpaces(String S, int length) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            builder.append(S.charAt(i) == ' ' ? "%20" : S.charAt(i));
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String x = "Mr John Smith    ";
        System.out.println(x.length());
    }

}
