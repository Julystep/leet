package practice;

/**
 * 颠倒二进制位
 */
public class Solution190 {

    public int reverseBits(int n) {

        int rev = 0;
        for (int i = 0; i < 32 && n != 0; ++i) {
            rev |= (n & 1) << (31 - i);
            n >>>= 1;
        }
        return rev;

    }

    public static void main(String[] args) {
        System.out.println(Integer.parseInt("10000010100101000001111010011100", 2));


    }

}
