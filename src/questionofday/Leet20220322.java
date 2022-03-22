package questionofday;


public class Leet20220322 {

    public boolean winnerOfGame(String colors) {
        int aAns = 0, bAns = 0;
        int countA = 0, countB = 0;
        for (int i = 0; i < colors.length(); i++) {
            if (colors.charAt(i) == 'A') {
                bAns += Math.max(countB - 2, 0);
                countA ++;
                countB = 0;
            }
            if (colors.charAt(i) == 'B') {
                aAns += Math.max(countA - 2, 0);
                countB ++;
                countA = 0;
            }
        }
        if (countA > 2) {
            aAns += countA - 2;
        }
        if (countB > 2) {
            bAns += countB - 2;
        }
        return aAns > bAns;
    }

}
