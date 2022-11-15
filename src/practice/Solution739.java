import java.util.Stack;

/**
 * 每日温度
 *
 * @author <a href="mailto:liml28084@hundsun.com">liml28084</a>
 * @since v0.0.0
 * @since 2022/11/9
 */
public class Solution739 {

    // 输入: temperatures = [73,74,75,71,69,72,76,73]
    // 输出: [1,1,4,2,1,1,0,0]
    public int[] dailyTemperatures(int[] T) {
        int []TIndex = new int[T.length];
        Stack<Integer> stackIndex = new Stack<>();
        stackIndex.push(0);
        for(int i = 1; i < T.length; i++){
            while(!stackIndex.isEmpty() && T[i] > T[stackIndex.peek()]){
                TIndex[stackIndex.peek()] = i - stackIndex.pop();
            }
            stackIndex.push(i);
        }
        return TIndex;
    }

}
