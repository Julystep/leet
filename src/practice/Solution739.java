import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 每日温度
 *
 * @since 2022/11/9
 */
public class Solution739 {

    // 输入: temperatures = [73,74,75,71,69,72,76,73]
    // 输出: [1,1,4,2,1,1,0,0]
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i = 1; i < temperatures.length; i++){
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                ans[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
        return ans;
    }

}
