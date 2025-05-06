import java.util.*;

public class TowerOfHanoi {
    static List<String> moves = new ArrayList<>();

    public static void solveHanoi(int n, char source, char auxiliary, char destination) {
        if (n == 1) {
            String move = "Move disk 1 from " + source + " to " + destination;
            System.out.println(move);
            moves.add(move);
            return;
        }

        solveHanoi(n - 1, source, destination, auxiliary);

        String move = "Move disk " + n + " from " + source + " to " + destination;
        System.out.println(move);
        moves.add(move);

        solveHanoi(n - 1, auxiliary, source, destination);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of disks: ");
        int n = scanner.nextInt();

        solveHanoi(n, 'S', 'A', 'D');

        System.out.println("\nTotal moves: " + moves.size());
    }
}
