package practice;

/**
 * N 字形变换
 */
public class Solution6 {
    /**
     *
     */
    public String convert(String s, int numRows) {
        int n = s.length();
        if (numRows == 1 || n < numRows) return s;
        int t = 2 * numRows - 2;
        int col = (n + t - 1) / t * (numRows - 1);
        char[][] pint = new char[numRows][col];
        for (int i = 0, x = 0, y = 0; i < n; i++) {
            pint[x][y] = s.charAt(i);
            if (i % t < numRows - 1) x++;
            else {
                x --;
                y ++;
            }
        }
        StringBuilder ans = new StringBuilder();
        for (char[] row : pint) {
            for (char ch : row) {
                if (ch != 0) {
                    ans.append(ch);
                }
            }
        }
        return ans.toString();
    }

}
