package practice;

import java.util.HashSet;
import java.util.Set;

/**
 * 快乐数
 */
public class Solution202 {

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (true) {
            int sum = 0;
            while (n != 0) {
                sum += (n % 10) * (n % 10);
                n = n / 10;
            }
            if (set.contains(sum)) return false;
            if (sum == 1) return true;
            set.add(sum);
            n = sum;
        }
    }

    public static void main(String[] args) {
        Solution202 solution202 = new Solution202();
        solution202.isHappy(19);
        System.out.println(Integer.MAX_VALUE);
    }

}
