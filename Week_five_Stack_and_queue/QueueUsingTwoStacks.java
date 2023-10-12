import java.util.Stack;

public class QueueUsingTwoStacks {
    int front;
    Stack<Integer> st1;
    Stack<Integer>st2;
    public QueueUsingTwoStacks() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }

    public void enqueue(int x) {
        if (st1.isEmpty()) {
            front = x;
        }
        st1.add(x);
    }

    public void dequeue() {
        if (st2.isEmpty()) {
            while (!st1.isEmpty()) {
                st2.add(st1.pop());
            }
        }
        st2.pop();
    }

    public int peek() {
        if (st2.isEmpty()) {
            return front;
        } else {
            return st2.peek();
        }
    }
}
