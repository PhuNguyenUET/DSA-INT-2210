import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Queue {
    int front;
    Stack<Integer>st1;
    Stack<Integer>st2;
    public Queue() {
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

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        Queue q = new Queue();
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int t = scanner.nextInt();
            if (t == 1) {
                int x = scanner.nextInt();
                q.enqueue(x);
            } else if (t == 2) {
                q.dequeue();
            } else {
                int res = q.peek();
                System.out.println(res);
            }
        }
    }
}
