package practice;


public class Solution201 {

    /**
     * 简单的两数相合的问题，这样能得到最优结果，但是会超时
     * 公共前缀
     */
    public int rangeBitwiseAnd(int left, int right) {
        int shift = 0;
        while (left < right) {
            left >>= 1;
            right >>= 1;
            shift++;
        }
        return left << shift;
    }

    public static void main(String[] args) {
        System.out.println(1 & 2147483647);
        System.out.println(Math.pow(2, 31));
    }

}
