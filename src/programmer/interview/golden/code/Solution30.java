package programmer.interview.golden.code;

/**
 * 翻转数位
 */
public class Solution30 {

    public int reverseBits(int num) {
        int[] bitNum = new int[32];
        for (int i = 0; i < 32; i++) {
            if ((num & 1) == 1) {
                bitNum[i] = 1;
            } else {
                bitNum[i] = 0;
            }
            num = num >> 1;
        }
        int[] pre = new int[33];
        int oneLong = 0;
        for (int i = 0; i < 32; i++) {
            if (bitNum[i] == 1) {
                oneLong++;
            } else {
                oneLong = 0;
            }
            pre[i + 1] = oneLong;
        }
        int preZero = -1;
        int max = 0;
        for (int i = 1; i < pre.length; i++) {
            if (pre[i] == 0) {
                preZero = i;
            }
            int prei = pre[i];
            int preNum = preZero != -1 ? pre[preZero - 1] + 1 : 0;
            int count = preNum + prei;
            max = Math.max(count, max);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution30 solution30 = new Solution30();
        solution30.reverseBits(1775);
    }

}
