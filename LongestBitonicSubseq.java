import java.util.*;

public class LongestBitonicSubseq {

    public static int longestBitonicSubsequence(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;

        int[] lis = new int[n]; // Longest Increasing Subsequence
        int[] lds = new int[n]; // Longest Decreasing Subsequence

        Arrays.fill(lis, 1);
        Arrays.fill(lds, 1);

        // Compute LIS from left to right
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                }
            }
        }

        // Compute LDS from right to left
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (arr[i] > arr[j] && lds[i] < lds[j] + 1) {
                    lds[i] = lds[j] + 1;
                }
            }
        }

        // Find the maximum of lis[i] + lds[i] - 1
        int maxLBS = 0;
        for (int i = 0; i < n; i++) {
            maxLBS = Math.max(maxLBS, lis[i] + lds[i] - 1);
        }

        return maxLBS;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = scanner.nextInt();

        System.out.println(longestBitonicSubsequence(arr));
    }
}
