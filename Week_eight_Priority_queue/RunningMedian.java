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

class Result {

    /*
     * Complete the 'runningMedian' function below.
     *
     * The function is expected to return a DOUBLE_ARRAY.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

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

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int aCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = IntStream.range(0, aCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<Double> result = Result.runningMedian(a);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
