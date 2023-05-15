package practice;

// 加油站
public class Solution134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int sum = 0;
        int start = 0;
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            sum += gas[i] - cost[i];
            if (sum < minSum) {
                start = i + 1;
                minSum = sum;
            }
        }
        if (sum < 0) return -1;
        return start == len ? 0 : start;
    }

    public static void main(String[] args) {
//        int[] gas = {1,2,3,4,5}, cost = {3,4,5,1,2};
        int[] gas = {4,3,1,2,7,4}, cost = {1,2,7,3,2,5};
        Solution134 solution134 = new Solution134();
        solution134.canCompleteCircuit(gas, cost);
        Thread thread = new Thread();
    }



    // 暴力解法，会超时
    public int canCompleteCircuit1(int[] gas, int[] cost) {

        int n = gas.length;
        for (int start = 0; start < n; start++) {
            int tank = 0;
            boolean flag = true;
            for (int step = 0; step < n; step++) {
                int i = (start + step) % n;
                tank += gas[i];
                tank -= cost[i];
                // 判断油箱中的油是否耗尽
                if (tank < 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) return start;
        }
        return -1;
    }

}
