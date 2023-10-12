import edu.princeton.cs.algs4.*;
public class DragonFractal {
    public static void main(String[] args) {
        int n = StdIn.readInt();
        String[] dp = new String[n];
        dp[0] = "F";
        for (int i = 1; i < n; i ++) {
            StringBuilder tmp = new StringBuilder(dp[i - 1]);
            for (int j = 0; j < tmp.length(); j ++) {
                if (tmp.charAt(j) == 'L') {
                    tmp.setCharAt(j, 'R');
                } else if (tmp.charAt(j) == 'R') {
                    tmp.setCharAt(j, 'L');
                }
            }
            tmp.reverse();
            String newString = dp[i - 1] +
                    "L" +
                    tmp;
            dp[i] = newString;
        }
        System.out.println(dp[n - 1]);
    }
}
