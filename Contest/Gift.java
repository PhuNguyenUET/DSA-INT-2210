import java.io.*;
import java.util.PriorityQueue;
import java.util.*;
public class Gift {
    static Scanner scanner = new Scanner(System.in);
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static void main(String[] args) {
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (pq.size() < k) {
                res += scanner.nextInt();
            } else {
                res -= pq.poll();
                int tmp = scanner.nextInt();
                res += tmp;
                pq.add(tmp);
            }
            System.out.println(res);
        }
    }
}
