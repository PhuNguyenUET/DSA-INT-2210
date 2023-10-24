import java.util.*;
import java.util.PriorityQueue;

public class JesseAndCookies {
    public static int cookies(int k, List<Integer> A) {
        // Write your code here
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.addAll(A);
        int res = 0;
        while ((pq.size() != 1) && pq.peek() < k) {
            int one = pq.poll();
            int two = pq.poll();
            pq.add(one + two * 2);
            res++;
        }
        if (pq.peek() < k) {
            return -1;
        } else {
            return res;
        }
    }
}
