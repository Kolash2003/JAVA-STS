import java.util.Scanner;

public class LCS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();

        System.out.println(lcs(str1, str2));
    }

    // Bottom-up dynamic programming approach
    public static int lcs(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        
        // DP table to store the length of LCS at each point
        int[][] dp = new int[m + 1][n + 1];

        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;  // If characters match
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);  // If no match, take max
                }
            }
        }

        // The bottom-right cell contains the length of LCS
        return dp[m][n];
    }
}
