import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.PriorityQueue;

public class RunningMedian {
    public static List<Double> runningMedian(List<Integer> a) {
        // Write your code here
        int n = a.size();
        List<Double> res = new ArrayList<>();
        double med = Integer.MIN_VALUE;
        Queue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> minPQ = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            if (a.get(i) >= med) {
                minPQ.add(a.get(i));
            } else {
                maxPQ.add(a.get(i));
            }
            if (maxPQ.size() > minPQ.size()) {
                minPQ.add(maxPQ.poll());
            }
            if (minPQ.size() - maxPQ.size() >= 2) {
                maxPQ.add(minPQ.poll());
            }
            if (maxPQ.size() == minPQ.size()) {
                med = ((double)minPQ.peek() + (double)maxPQ.peek())/2.0;
                res.add(med);
            } else {
                med = minPQ.peek();
                res.add(med);
            }
        }
        return res;
    }
}
