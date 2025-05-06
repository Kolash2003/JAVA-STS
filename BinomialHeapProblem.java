import java.util.*;

class BinomialHeapNode {
    int key, degree;
    BinomialHeapNode parent, sibling, child;

    public BinomialHeapNode(int key) {
        this.key = key;
    }

    public BinomialHeapNode findMinNode() {
        BinomialHeapNode min = this, current = this;
        while (current != null) {
            if (current.key < min.key) min = current;
            current = current.sibling;
        }
        return min;
    }

    public BinomialHeapNode findNode(int value) {
        if (this.key == value) return this;
        BinomialHeapNode res = null;
        if (child != null) res = child.findNode(value);
        if (res != null) return res;
        if (sibling != null) res = sibling.findNode(value);
        return res;
    }

    public int getSize() {
        int size = 1;
        if (child != null) size += child.getSize();
        if (sibling != null) size += sibling.getSize();
        return size;
    }
}

class BinomialHeap {
    private BinomialHeapNode head;
    private int size;

    public boolean isEmpty() {
        return head == null;
    }

    public int getSize() {
        return size;
    }

    public void makeEmpty() {
        head = null;
        size = 0;
    }

    public void insert(int value) {
        BinomialHeap temp = new BinomialHeap();
        temp.head = new BinomialHeapNode(value);
        union(temp);
        size++;
    }

    public int findMinimum() {
        if (head == null) return -1;
        return head.findMinNode().key;
    }

    public void delete(int value) {
        decreaseKey(value, Integer.MIN_VALUE);
        extractMin();
    }

    public void decreaseKey(int oldValue, int newValue) {
        BinomialHeapNode node = head.findNode(oldValue);
        if (node == null || newValue > node.key) return;

        node.key = newValue;
        BinomialHeapNode current = node, parent = node.parent;

        while (parent != null && current.key < parent.key) {
            int tmp = current.key;
            current.key = parent.key;
            parent.key = tmp;

            current = parent;
            parent = current.parent;
        }
    }

    public int extractMin() {
        if (head == null) return -1;

        // Find minimum root
        BinomialHeapNode minPrev = null, minNode = head, prev = null, curr = head;
        int min = head.key;

        while (curr != null) {
            if (curr.key < min) {
                min = curr.key;
                minNode = curr;
                minPrev = prev;
            }
            prev = curr;
            curr = curr.sibling;
        }

        // Remove minNode from root list
        if (minPrev != null)
            minPrev.sibling = minNode.sibling;
        else
            head = minNode.sibling;

        // Reverse children and union
        BinomialHeapNode child = reverseChildren(minNode.child);

        BinomialHeap temp = new BinomialHeap();
        temp.head = child;

        union(temp);

        size = head == null ? 0 : head.getSize();
        return minNode.key;
    }

    private BinomialHeapNode reverseChildren(BinomialHeapNode node) {
        BinomialHeapNode prev = null;
        while (node != null) {
            BinomialHeapNode next = node.sibling;
            node.sibling = prev;
            node.parent = null;
            prev = node;
            node = next;
        }
        return prev;
    }

    private void union(BinomialHeap other) {
        head = merge(this.head, other.head);
        if (head == null) return;

        BinomialHeapNode prev = null, curr = head, next = curr.sibling;

        while (next != null) {
            if (curr.degree != next.degree ||
                (next.sibling != null && next.sibling.degree == curr.degree)) {
                prev = curr;
                curr = next;
            } else if (curr.key <= next.key) {
                curr.sibling = next.sibling;
                linkTrees(curr, next);
            } else {
                if (prev == null) head = next;
                else prev.sibling = next;
                linkTrees(next, curr);
                curr = next;
            }
            next = curr.sibling;
        }
    }

    private void linkTrees(BinomialHeapNode parent, BinomialHeapNode child) {
        child.parent = parent;
        child.sibling = parent.child;
        parent.child = child;
        parent.degree++;
    }

    private BinomialHeapNode merge(BinomialHeapNode h1, BinomialHeapNode h2) {
        if (h1 == null) return h2;
        if (h2 == null) return h1;

        BinomialHeapNode head, tail;

        if (h1.degree <= h2.degree) {
            head = h1;
            h1 = h1.sibling;
        } else {
            head = h2;
            h2 = h2.sibling;
        }

        tail = head;

        while (h1 != null && h2 != null) {
            if (h1.degree <= h2.degree) {
                tail.sibling = h1;
                h1 = h1.sibling;
            } else {
                tail.sibling = h2;
                h2 = h2.sibling;
            }
            tail = tail.sibling;
        }

        tail.sibling = (h1 != null) ? h1 : h2;
        return head;
    }

    public void displayHeap() {
        System.out.print("Heap: ");
        displayTree(head);
        System.out.println();
    }

    private void displayTree(BinomialHeapNode node) {
        if (node == null) return;
        System.out.print(node.key + " ");
        displayTree(node.child);
        displayTree(node.sibling);
    }

}

public class BinomialHeapProblem {
    public static void main(String[] args) {
        BinomialHeap heap = new BinomialHeap();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements to insert: ");
        int n = sc.nextInt();
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            heap.insert(sc.nextInt());
        }

        System.out.println("Heap size: " + heap.getSize());
        heap.displayHeap();

        System.out.print("Enter value to delete: ");
        int del = sc.nextInt();
        heap.delete(del);

        System.out.println("After deletion:");
        System.out.println("Heap size: " + heap.getSize());
        heap.displayHeap();

        System.out.println("Is heap empty? " + heap.isEmpty());
        heap.makeEmpty();
        System.out.println("Heap emptied. Is heap empty? " + heap.isEmpty());
    }
}
