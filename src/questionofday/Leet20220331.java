package questionofday;


import java.util.ArrayList;
import java.util.List;

public class Leet20220331 {

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            int c = i;
            while (c != 0) {
                if (c % 10 == 0 || i % (c % 10) != 0) {
                    break;
                }
                c /= 10;
            }
            if (c == 0) {
                ans.add(i);
            }
        }
        return ans;
    }

}
