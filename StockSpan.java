import java.util.*;

public class StockSpan {
    
    // Function to calculate stock span
    static void calculate(int arr[], int n, int S[]) {
        Stack<Integer> st = new Stack<>();
        
        // Traverse the array
        for (int i = 0; i < n; i++) {
            // Pop elements from stack while current element is greater than or equal to stack's top element
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }
            
            // If stack is empty, span is i + 1, else it's the difference between current index and stack's top index
            S[i] = (st.isEmpty()) ? (i + 1) : (i - st.peek());
            
            // Push current element index to the stack
            st.push(i);
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        
        // Input array elements
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        int S[] = new int[n];
        
        // Calculate the stock span
        calculate(arr, n, S);
        
        // Output the result directly
        System.out.println(Arrays.toString(S));
    }
}
