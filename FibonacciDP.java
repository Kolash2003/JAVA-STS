import java.util.*;

public class FibonacciDP {
    public static int fibonacci(int n) {
        if (n <= 1) return n;

        int[] dp = new int[n + 1]; // Create array to store Fibonacci values
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2]; // DP recurrence
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 10; // Change this value to compute different Fibonacci numbers
        System.out.println("Fibonacci number at position " + n + " is: " + fibonacci(n));
    }
}
