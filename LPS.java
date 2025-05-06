import java.util.Scanner;

public class LPS {
    public static int lps(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        // Fill the dp table
        for (int len = 1; len <= n; len++) {
            for (int start = 0; start <= n - len; start++) {
                int end = start + len - 1;
                if (len == 1) {
                    dp[start][end] = 1;
                } else if (s.charAt(start) == s.charAt(end)) {
                    dp[start][end] = 2 + (start + 1 <= end - 1 ? dp[start + 1][end - 1] : 0);
                } else {
                    dp[start][end] = Math.max(dp[start + 1][end], dp[start][end - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(lps(s));
    }
}
