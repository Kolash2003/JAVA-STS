import java.util.LinkedList;
import java.util.Scanner;

public class SegregateEvenOdd {
    public static void main(String[] args) {
        // Sample input LinkedList
        LinkedList<Integer> numbers = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0; i<n; i++) {
            int a = sc.nextInt();
            numbers.add(a);
        }
        
        // LinkedLists to store even and odd numbers
        LinkedList<Integer> evenNumbers = new LinkedList<>();
        LinkedList<Integer> oddNumbers = new LinkedList<>();

        // Traverse through the input list and segregate even and odd numbers
        for (Integer num : numbers) {
            if (num % 2 == 0) {
                evenNumbers.add(num);  // Add to evenNumbers
            } else {
                oddNumbers.add(num);   // Add to oddNumbers
            }
        }

        // Print the segregated lists
        System.out.println("Even Numbers: " + evenNumbers);
        System.out.println("Odd Numbers: " + oddNumbers);
    }
}
