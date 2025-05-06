import java.util.*;

class Node {
    int idx;
    Node left, right;
    Node(int i) { idx = i; }
}

public class WinnerTree {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] arr = Arrays.stream(s.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        findSecondMin(arr);
    }

    static void findSecondMin(int[] arr) {
        if (arr.length < 1) return;
        
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            nodes.add(new Node(i));
        
        while (nodes.size() > 1) {
            List<Node> temp = new ArrayList<>();
            for (int i = 0; i < nodes.size(); i += 2) {
                if (i+1 >= nodes.size()) {
                    temp.add(nodes.get(i));
                    break;
                }
                Node a = nodes.get(i), b = nodes.get(i+1);
                Node winner = new Node(arr[a.idx] < arr[b.idx] ? a.idx : b.idx);
                winner.left = a;
                winner.right = b;
                temp.add(winner);
            }
            nodes = temp;
        }
        
        int secMin = Integer.MAX_VALUE;
        Node curr = nodes.get(0);
        while (curr.left != null) {
            Node loser = curr.left.idx == curr.idx ? curr.right : curr.left;
            if (arr[loser.idx] < secMin) secMin = arr[loser.idx];
            curr = curr.left.idx == curr.idx ? curr.left : curr.right;
        }
        
        System.out.println("Min: " + arr[nodes.get(0).idx] + 
                          "\nSecond: " + (secMin == Integer.MAX_VALUE ? "-" : secMin));
    }
}
