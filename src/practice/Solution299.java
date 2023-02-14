package practice;

/**
 * 猜数字游戏
 */
public class Solution299 {

    public String getHint(String secret, String guess) {
        int bulls = 0;
        int[] sCnt = new int[10];
        int[] gCnt = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            } else {
                sCnt[secret.charAt(i) - '0']++;
                gCnt[guess.charAt(i) - '0']++;
            }
        }
        int cows = 0;
        for (int i = 0; i < 10; i++) {
            cows += Math.min(sCnt[i], gCnt[i]);
        }
        return bulls + "A" + cows + "B";
    }

    public static void main(String[] args) {
        Solution299 solution299 = new Solution299();
        solution299.getHint("11", "10");
    }

}
