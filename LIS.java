import java.util.Scanner;

public class LIS {
    public static int lis(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        int maxLIS = 1;

        // Initialize dp array
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        // Compute LIS values
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLIS = Math.max(maxLIS, dp[i]);
        }

        return maxLIS;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(lis(arr));
    }
}
