/**
 * 字符串相乘
 * @since 2022/11/21
 */
public class Solution43 {

    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";
        int m = num1.length(), n = num2.length();
        // 乘积的最大长度为 m + n
        int[] ans = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            int a = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int b = num2.charAt(j) - '0';
                ans[i + j + 1] += a * b;
            }
        }

        for (int i = m + n - 1; i >=0; i--) {
            ans[i - 1] += ans[i] / 10;
            ans[i] %= 10;
        }

        String result = "";
        int i = 0;
        for (;i < m + n; i++) {
            if (ans[i] != 0) break;
        }
        for (;i < m + n; i++) {
            result += ans[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Solution43 solution43 = new Solution43();
        System.out.println(solution43.multiply("999", "231"));
    }

}
