import java.util.*;

class Node {
    int num;
    Node next;
    Node(int val) {
        num = val;
        next = null;
    }
}

class LoopDetection {
    static Node insertNode(Node head, int val) {
        Node newNode = new Node(val);
        if (head == null) return newNode;
        Node temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = newNode;
        return head;
    }

    static void display(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.num + "->");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    static void createCycle(Node head, int a) {
        Node p1 = head, p2 = head;
        for (int i = 0; i < a; i++) p2 = p2.next;
        while (p1.next != null) p1 = p1.next;
        p1.next = p2;  // Creating cycle
    }

    static boolean cycleDetect(Node head) {
        if (head == null) return false;
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true; // Cycle detected
        }
        return false; // No cycle
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node head = null;
        for (int i = 0; i < n; i++) head = insertNode(head, sc.nextInt());
        display(head);
        createCycle(head, 1); // Creating cycle
        System.out.println(cycleDetect(head) ? "Cycle detected" : "Cycle not detected");
    }
}
