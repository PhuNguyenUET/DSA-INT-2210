import java.io.*;
import java.util.PriorityQueue;
import java.util.*;

public class Median {
    static Scanner scanner = new Scanner(System.in);
    static Queue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
    static Queue<Integer> minPQ = new PriorityQueue<>();
    static int med = Integer.MIN_VALUE;

    public static void add(int p) {
        if (p >= med) {
            minPQ.add(p);
        } else {
            maxPQ.add(p);
        }
        if (maxPQ.size() > minPQ.size()) {
            minPQ.add(maxPQ.poll());
        }
        if (minPQ.size() - maxPQ.size() >= 2) {
            maxPQ.add(minPQ.poll());
        }
        med = minPQ.peek();
    }

    public static void delMedian() {
        minPQ.poll();
        if (maxPQ.size() > minPQ.size()) {
            minPQ.add(maxPQ.poll());
        }
        if (minPQ.size() - maxPQ.size() >= 2) {
            maxPQ.add(minPQ.poll());
        }
        med = minPQ.peek();
    }

    public static void main(String[] args) {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            add(scanner.nextInt());
        }
        for (int i = 0; i < m; i++) {
            int choice = scanner.nextInt();
            if (choice == 1) {
                add(scanner.nextInt());
            } else if (choice == 2) {
                delMedian();
            } else {
                System.out.println(med);
            }
        }
    }
}
