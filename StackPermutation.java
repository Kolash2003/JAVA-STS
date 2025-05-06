import java.util.*;

public class StackPermutation {
    
    // Function to check if the output is a valid stack permutation of the input
    static Boolean check(int ip[], int op[], int n) {
        Stack<Integer> s = new Stack<Integer>();
        int j = 0;
        for (int i = 0; i < n; i++) {
            s.push(ip[i]);  // Push elements from input to the stack
            while (!s.isEmpty() && s.peek() == op[j]) {  // Check if the top of the stack matches the output
                s.pop();  // Pop if the top matches the output
                j++;
            }
        }
        return s.isEmpty();  // If the stack is empty, the permutation is valid
    }

    public static void main(String[] args) {
        int ip[] = {1, 2, 3};  // Input sequence
        int op[] = {3, 2, 1};  // Desired output sequence
        int n = ip.length;     // Length of the sequence
        
        if (check(ip, op, n)) {
            System.out.println("Yes, the output is a valid stack permutation.");
        } else {
            System.out.println("No, the output is not a valid stack permutation.");
        }
    }
}
