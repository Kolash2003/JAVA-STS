import java.util.*;

public class VerticalOrder {

    // ✅ Correct: define Node as static nested or top-level class
    static class Node {
        int val;
        Node left, right;
        Node(int v) { val = v; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().split(" ");
        Node root = buildTree(arr);
        printVertical(root);
    }

    static Node buildTree(String[] arr) {
        if (arr[0].equals("N")) return null;
        Node root = new Node(Integer.parseInt(arr[0]));
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        int i = 1;
        while (!q.isEmpty() && i < arr.length) {
            Node curr = q.poll();

            if (!arr[i].equals("N")) {
                curr.left = new Node(Integer.parseInt(arr[i]));
                q.add(curr.left);
            }
            i++;

            if (i < arr.length && !arr[i].equals("N")) {
                curr.right = new Node(Integer.parseInt(arr[i]));
                q.add(curr.right);
            }
            i++;
        }
        return root;
    }

    static void printVertical(Node root) {
        TreeMap<Integer, TreeMap<Integer, List<Integer>>> map = new TreeMap<>();
        traverse(root, 0, 0, map);

        for (TreeMap<Integer, List<Integer>> cols : map.values()) {
            for (List<Integer> vals : cols.values()) {
                Collections.sort(vals);
                for (int v : vals) System.out.print(v + " ");
            }
        }
    }

    static void traverse(Node node, int x, int y, TreeMap<Integer, TreeMap<Integer, List<Integer>>> map) {
        if (node == null) return;

        map.putIfAbsent(x, new TreeMap<>());
        map.get(x).putIfAbsent(y, new ArrayList<>());
        map.get(x).get(y).add(node.val);

        traverse(node.left, x - 1, y + 1, map);
        traverse(node.right, x + 1, y + 1, map);
    }
}
