package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 括号生成
 *
 * @author <a href="mailto:liml28084@hundsun.com">liml28084</a>
 * @since v
 * @since 2023/7/27
 */
public class Solution22 {

    List<String> ans = new ArrayList<>();
    StringBuilder builder = new StringBuilder();

    public List<String> generateParenthesis(int n) {

        dfs(0, 0, n);
        return ans;

    }

    public void dfs(int open, int close, int max) {
        if (builder.length() == max * 2) {
            ans.add(builder.toString());
        }
        if (open < max) {
            builder.append('(');
            dfs(open + 1, close, max);
            builder.deleteCharAt(builder.length() - 1);
        }
        if (close < open) {
            builder.append(')');
            dfs(open, close+1, max);
            builder.deleteCharAt(builder.length() - 1);
        }
    }

    public static void main(String[] args) {
        Solution22 solution22 = new Solution22();
        System.out.println(solution22.generateParenthesis(3));
    }

}
