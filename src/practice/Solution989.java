import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 数组形式的整数加法
 *
 * @since 2022/11/22
 */
public class Solution989 {

    public List<Integer> addToArrayForm(int[] num, int k) {
        Stack<Integer> stack = new Stack<>();
        int n = num.length - 1;
        num[n] += k;
        for (int i = n; i > 0; i--) {
            stack.push(num[i]%10);
            num[i-1] += num[i]/10;
        }
        while (num[0] / 10 != 0) {
            stack.push(num[0] % 10);
            num[0] /= 10;
        }
        stack.push(num[0] %= 10);
        List<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) result.add(stack.pop());
        return result;
    }

}
