package practice;

/**
 * 旋转字符串
 */
public class Solution796 {
    public boolean rotateString(String s, String goal) {
        return s.length() == goal.length() && (s + s).contains(goal);
    }

    public static void main(String[] args) {
        Solution796 solution796 = new Solution796();
        solution796.rotateString("abcde", "cdeab");


        String x = "123";
        System.out.println(x.substring(3, 3));

    }

}
