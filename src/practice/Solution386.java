package practice;

import java.util.ArrayList;
import java.util.List;

/**
 * 字典序：递归与迭代双重解法
 */

public class Solution386 {

    // 迭代
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        int number = 1;
        for (int i = 0; i < n; i++) {
            list.add(number);
            if (number * 10 <= n) {
                number *= 10;
            } else {
                while (number % 10 == 9 || number + 1 > n) {
                    number /= 10;
                }
                number ++;
            }
        }
        return list;
    }

    // 递归
    public List<Integer> lexicalOrderDg(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 9; i++) dfs(list, i, n);
        return list;
    }

    private void dfs(List<Integer> list, int cur, int n) {
        if (cur > n) return;
        list.add(cur);
        for (int i = 0; i <= 9; i++) dfs(list, cur * 10 + i, n);
    }

}
