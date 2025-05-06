import java.util.*;

class Mystack {
    Stack<Integer> s, a;
    
    Mystack() {
        s = new Stack<>();
        a = new Stack<>();
    }

    void getMin() {
        if (a.isEmpty()) System.out.println("Stack is Empty");
        else System.out.println("Minimum element : " + a.peek());
    }

    void peek() {
        if (s.isEmpty()) System.out.println("Stack is Empty");
        else System.out.println("Top most element: " + s.peek());
    }

    void pop() {
        if (s.isEmpty()) {
            System.out.println("Stack is Empty");
            return;
        }
        int t = s.pop();
        System.out.println("Removed element : " + t);
        if (t == a.peek()) a.pop();
    }

    void push(int x) {
        s.push(x);
        if (a.isEmpty() || x <= a.peek()) a.push(x);
        System.out.println("Number Inserted: " + x);
    }
}

public class MinStack {
    public static void main(String args[]) {
        Mystack s = new Mystack();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) s.push(sc.nextInt());
        s.getMin();
        s.pop();
        s.getMin();
        s.pop();
        s.peek();
    }
}
