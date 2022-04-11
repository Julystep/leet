package questionofday;

public class Leet20220327 {

    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int missingSum = mean * (n + m);
        for (int roll : rolls) {
            missingSum -= roll;
        }
        if (missingSum < n || missingSum > 6 * n) {
            return new int[0];
        }
        int quotient = missingSum / n, remainder = missingSum % n;
        int[] missing = new int[n];
        for (int i = 0; i < n; i++) {
            missing[i] = quotient + (i < remainder ? 1 : 0);
        }
        return missing;
    }

    public static void main(String[] args) {
        int[] x = {4,5,6,2,3,6,5,4,6,4,5,1,6,3,1,4,5,5,3,2,3,5,3,2,1,5,4,3,5,1,5};
        System.out.println(new Leet20220327().missingRolls(x, 4, 40));
    }

}
