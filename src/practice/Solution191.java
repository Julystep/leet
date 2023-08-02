package practice;


public class Solution191 {

    public int hammingWeight(int n) {
        int ans = 0;
        while (n != 0) {
            if ((n & 1) == 1) ans ++;
            n >>>= 1;
        }
        return ans;
    }

    // leet更好的方案，n  & n - 1 会把n的最低位的1给置为0
    public int hammingWeight1(int n) {
        int ans = 0;
        while (n != 0) {
            n = n & (n - 1);
            ans++;
        }
        return ans;
    }

}
