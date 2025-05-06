import java.util.LinkedList;

public class SegregateEvenOdd {
    public static void main(String[] args) {
        // Sample input LinkedList
        LinkedList<Integer> numbers = new LinkedList<>();
        numbers.add(10);
        numbers.add(21);
        numbers.add(32);
        numbers.add(43);
        numbers.add(54);
        numbers.add(65);
        
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
