package questionofday;

public class Leet20220328 {

    public boolean hasAlternatingBits(int n) {
        int flag = -1;
        while (n != 0) {
            if (flag == n % 2) {
                return false;
            }
            flag = n % 2;
            n /= 2;
        }
        return true;
    }

}
