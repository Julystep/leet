package practice;

import java.util.Objects;
import java.util.Stack;

/**
 * 简化路径
 */
public class Solution71 {

    public String simplifyPath(String path) {
        String[] dirs = path.split("/");
        Stack<String> stack = new Stack<>();
        for (int i = 1; i < dirs.length; i++) {
            if (Objects.equals(dirs[i], "..") && !stack.isEmpty()) stack.pop();
            else if (!Objects.equals(dirs[i], ".") && !Objects.equals(dirs[i], "") && !Objects.equals(dirs[i], "..")) stack.push("/" + dirs[i]);
        }
        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()) {
            ans.insert(0, stack.pop());
        }
        return Objects.equals(ans.toString(), "") ? "/" : ans.toString();
    }




    public static void main(String[] args) {
        String x = "/a/./b/../../c/";
        Solution71 solution71 = new Solution71();
        System.out.println(solution71.simplifyPath(x));
    }

}
