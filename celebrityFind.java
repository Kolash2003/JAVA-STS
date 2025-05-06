import java.util.*;

public class celebrityFind {

     public static int findCelebrity(int[][] mat, int n) {
        int[] knowsme = new int[n];
        int[] iknow = new int[n];
        int candidate = -1;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(mat[i][j] == 1) {
                    knowsme[j]++;
                    iknow[i]++;
                }

            }
        }

        for(int i=0; i<n; i++) {
            if(knowsme[i]==n-1 && iknow[i]==0) {
                candidate = i;
            }
        }

        return candidate;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] mat = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                mat[i][j] = sc.nextInt();

        int result = findCelebrity(mat, n);

        if (result == -1)
            System.out.println("There is no celebrity in the party");
        else
            System.out.println(result + " is the celebrity in the party");
    }
}