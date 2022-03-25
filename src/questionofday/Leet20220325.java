package questionofday;

// 题目实际上是找有几个5或者10；有几个就有几个0
public class Leet20220325 {

    public int trailingZeroes(int n) {
        int ans = 0;
        int i = 1;
        while (i * 5 <= n) {
            ans ++;
            int c = i;
            while (c % 5 == 0) {
                c = c / 5;
                ans ++;
            }
            i++;
        }
        return ans;
    }

    /*public int trailingZeroes(int n) {
        int ans = 0;
        while (n != 0) {
            n /= 5;
            ans += n;
        }
        return ans;
    }
}*/

}
