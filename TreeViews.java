import java.util.*;

class Node {
    int data, hd;
    Node left, right;
    public Node(int data) {
        this.data = data;
        hd = Integer.MAX_VALUE;
    }
}

public class TreeViews {
    Node root;
    
    static Node build(String[] s) {
        if (s.length == 0 || s[0].equals("N")) return null;
        Node root = new Node(Integer.parseInt(s[0]));
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        for (int i = 1; i < s.length; i += 2) {
            Node curr = q.poll();
            if (!s[i].equals("N")) {
                curr.left = new Node(Integer.parseInt(s[i]));
                q.add(curr.left);
            }
            if (i+1 < s.length && !s[i+1].equals("N")) {
                curr.right = new Node(Integer.parseInt(s[i+1]));
                q.add(curr.right);
            }
        }
        return root;
    }

    void rightView(Node root) {
        if (root == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                Node curr = q.poll();
                if (i == n-1) System.out.print(curr.data + " ");
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
        }
    }

    void leftView(Node root) {
        if (root == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                Node curr = q.poll();
                if (i == 0) System.out.print(curr.data + " ");
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
        }
    }

    void topView(Node root) {
        if (root == null) return;
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Object[]> q = new LinkedList<>();
        q.add(new Object[]{root, 0});
        
        while (!q.isEmpty()) {
            Object[] curr = q.poll();
            Node node = (Node) curr[0];
            int hd = (int) curr[1];
            
            if (!map.containsKey(hd)) map.put(hd, node.data);
            if (node.left != null) q.add(new Object[]{node.left, hd-1});
            if (node.right != null) q.add(new Object[]{node.right, hd+1});
        }
        map.values().forEach(v -> System.out.print(v + " "));
    }

    void bottomView(Node root) {
        if (root == null) return;
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Object[]> q = new LinkedList<>();
        q.add(new Object[]{root, 0});
        
        while (!q.isEmpty()) {
            Object[] curr = q.poll();
            Node node = (Node) curr[0];
            int hd = (int) curr[1];
            
            map.put(hd, node.data);
            if (node.left != null) q.add(new Object[]{node.left, hd-1});
            if (node.right != null) q.add(new Object[]{node.right, hd+1});
        }
        map.values().forEach(v -> System.out.print(v + " "));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node root = build(sc.nextLine().split(" "));
        TreeViews tv = new TreeViews();
        
        tv.rightView(root); System.out.println();
        tv.leftView(root); System.out.println();
        tv.topView(root); System.out.println();
        tv.bottomView(root);
    }
}
