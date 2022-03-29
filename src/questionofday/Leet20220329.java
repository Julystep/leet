package questionofday;


public class Leet20220329 {

    // 输入：answerKey = "TTFF", k = 2
    //输出：4
    //解释：我们可以将两个 'F' 都变为 'T' ，得到 answerKey = "TTTT" 。
    //总共有四个连续的 'T' 。
    //

    // 输入：answerKey = "TTFTTFTT", k = 1
    //输出：5
    //解释：我们可以将第一个 'F' 换成 'T' ，得到 answerKey = "TTTTTFTT" 。
    //或者我们可以将第二个 'F' 换成 'T' ，得到 answerKey = "TTFTTTTT" 。
    //两种情况下，都有五个连续的 'T' 。


    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(getMax(answerKey, k, 'T'), getMax(answerKey, k, 'F'));
    }

    private int getMax(String answerKey, int k, char ch) {
        int len = answerKey.length();
        int ans = 0;
        for (int left = 0, right = 0, sum = 0; right < len; right ++) {
            sum += answerKey.charAt(right) != ch ? 1 : 0;
            while (sum > k) {
                sum -= answerKey.charAt(left++) != ch ? 1 :0;
            }
            ans = Math.max(ans, right -left + 1);
        }
        return ans;
    }

}
