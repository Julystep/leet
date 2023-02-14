package practice;

/**
 * 字符串转化后的各位数字之和
 */
public class Solution1945 {

    public int getLucky(String s, int k) {
        StringBuilder cache = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            cache.append(s.charAt(i) - 'a' + 1);
        }
        String ans = cache.toString();
        for (int i = 0; i < k; i ++) {
            int num = 0;
            for (int j = 0; j < ans.length(); j++) {
                num += ans.charAt(j) - '0';
            }
            ans = String.valueOf(num);
        }
        return Integer.parseInt(ans);
    }

    public static void main(String[] args) {
        System.out.println('1');
    }

}
