import java.util.*;

public class celebrityFind {

     public static int findCelebrity(int[][] mat) {
        int n = mat.length;
        Stack<Integer> stack = new Stack<>();

        // Push all people into the stack
        for (int i = 0; i < n; i++) stack.push(i);

        // Find a potential celebrity
        while (stack.size() > 1) {
            int a = stack.pop();
            int b = stack.pop();
            stack.push(mat[a][b] == 1 ? b : a);
        }

        int candidate = stack.pop();

        // Verify the candidate
        for (int i = 0; i < n; i++) {
            if (i != candidate && (mat[candidate][i] == 1 || mat[i][candidate] == 0)) {
                return -1;
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

        int result = findCelebrity(mat);

        if (result == -1)
            System.out.println("There is no celebrity in the party");
        else
            System.out.println(result + " is the celebrity in the party");
    }
}