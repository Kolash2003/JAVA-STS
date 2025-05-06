import java.util.*;

public class RecoverBST {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    public void recoverTree(TreeNode root) {
        TreeNode[] swap = new TreeNode[2];
        TreeNode curr = root, prev = null;
        Stack<TreeNode> s = new Stack<>();
        
        while (!s.empty() || curr != null) {
            while (curr != null) {
                s.push(curr);
                curr = curr.left;
            }
            curr = s.pop();
            if (prev != null && prev.val > curr.val) {
                if (swap[0] == null) swap[0] = prev;
                swap[1] = curr;
            }
            prev = curr;
            curr = curr.right;
        }
        
        // Swap the values of the two nodes to recover the BST
        int temp = swap[0].val;
        swap[0].val = swap[1].val;
        swap[1].val = temp;
    }
    
    static void printInorder(TreeNode n) {
        if (n == null) return;
        printInorder(n.left);
        System.out.print(n.val + " ");
        printInorder(n.right);
    }

    public static void main(String[] args) {
        // Construct a BST where two nodes are swapped
        // Example:  3
        //          / \
        //         1   4
        //            / 
        //           2
        // Nodes 2 and 3 are swapped to make it invalid
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2);

        System.out.print("Before recovery: ");
        printInorder(root);
        System.out.println();

        // Recover the BST
        new RecoverBST().recoverTree(root);

        System.out.print("After recovery: ");
        printInorder(root);
        System.out.println();
    }
}
