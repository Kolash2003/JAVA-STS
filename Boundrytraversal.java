import java.util.*;

class Node {
    int data;
    Node left, right;
    Node(int d) { data = d; }
}

public class Boundrytraversal {
    static Node build(String[] s) {
        if (s.length == 0 || s[0].equals("N")) return null;
        Node root = new Node(Integer.parseInt(s[0]));
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while (!q.isEmpty() && i < s.length) {
            Node curr = q.poll();
            if (!s[i].equals("N")) {
                curr.left = new Node(Integer.parseInt(s[i]));
                q.add(curr.left);
            }
            i++;
            if (i < s.length && !s[i].equals("N")) {
                curr.right = new Node(Integer.parseInt(s[i]));
                q.add(curr.right);
            }
            i++;
        }
        return root;
    }

    static void printLeft(Node node) {
        if (node == null || (node.left == null && node.right == null)) return;
        System.out.print(node.data + " ");
        if (node.left != null) printLeft(node.left);
        else printLeft(node.right);
    }

    static void printLeaves(Node node) {
        if (node == null) return;
        printLeaves(node.left);
        if (node.left == null && node.right == null)
            System.out.print(node.data + " ");
        printLeaves(node.right);
    }

    static void printRight(Node node) {
        if (node == null || (node.left == null && node.right == null)) return;
        if (node.right != null) printRight(node.right);
        else printRight(node.left);
        System.out.print(node.data + " ");
    }

    static void printBoundary(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        printLeft(root.left);
        printLeaves(root.left);
        printLeaves(root.right);
        printRight(root.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node root = build(sc.nextLine().split(" "));
        printBoundary(root);
    }
}
