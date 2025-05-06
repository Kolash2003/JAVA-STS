import java.util.*;

public class PriorityQueue {
    static class Node {
        int data, priority;
        Node next;
        Node(int d, int p) { data = d; priority = p; }
    }
    
    private static Node head;
    
    private static void push(int data, int priority) {
        Node node = new Node(data, priority);
        if (head == null) {
            head = node;
            return;
        }
        
        Node current = head, prev = null;
        while (current != null && current.priority >= priority) {
            prev = current;
            current = current.next;
        }
        
        if (prev == null) {
            node.next = head;
            head = node;
        } else {
            node.next = prev.next;
            prev.next = node;
        }
    }
    
    private static int peek() { return head != null ? head.data : -1; }
    
    private static int pop() {
        if (head == null) return -1;
        int data = head.data;
        head = head.next;
        return data;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) push(sc.nextInt(), sc.nextInt());
        
        System.out.println(peek());
        System.out.println(pop());
        System.out.println(pop());
        System.out.println(peek());
    }
}
