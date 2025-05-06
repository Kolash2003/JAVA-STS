import java.util.*;

public class PriorityQueue {
    static class Node {
        int data, priority;
        Node(int d, int p) {
            data = d;
            priority = p;
        }
    }

    static List<Node> list = new ArrayList<>();

    static void push(int data, int priority) {
        list.add(new Node(data, priority));
    }

    static int peek() {
        if (list.isEmpty()) return -1;
        Node maxNode = list.get(0);
        for (Node node : list) {
            if (node.priority > maxNode.priority) {
                maxNode = node;
            }
        }
        return maxNode.data;
    }

    static int pop() {
        if (list.isEmpty()) return -1;
        int maxIndex = 0;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).priority > list.get(maxIndex).priority) {
                maxIndex = i;
            }
        }
        return list.remove(maxIndex).data;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        while (n-- > 0) {
            int data = sc.nextInt();
            int priority = sc.nextInt();
            push(data, priority);
        }

        System.out.println(peek());
        System.out.println(pop());
        System.out.println(pop());
        System.out.println(peek());
    }
}
