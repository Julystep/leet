package practice;

import java.util.Arrays;

/**
 * 你能构造出连续值的最大数目
 *
 * 想到排序了，但是没想到排序后的规律
 *
 * 什么也不取的时候长度是1，如果长度为1时，第一个数据为2，那么无论怎么加也加不到2
 * 但是如果是1，则可以直接顺延，利用这种思路去解
 *
 */
public class Solution1798 {

    public int getMaximumConsecutive(int[] coins) {
        int res = 1;
        Arrays.sort(coins);
        for (int i : coins) {
            if (i > res) {
                break;
            }
            res += i;
        }
        return res;
    }

}
