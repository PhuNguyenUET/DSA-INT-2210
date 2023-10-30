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

class PQ {
    private int[] pq;
    private int n = 0;
    public PQ(int capacity) {
        pq = new int[capacity + 1];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void insert(int key) {
        pq[++n] = key;
        int k = n;
        while (k > 1 && pq[k/2] > pq[k]) {
            int tmp = pq[k];
            pq[k] = pq[k/2];
            pq[k/2] = tmp;
            k = k/2;
        }
    }

    public int delMin() {
        int mn = pq[1];
        int tmp = pq[1];
        pq[1] = pq[n];
        pq[n] = tmp;
        n --;
        int k = 1;
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && pq[j] > pq[j + 1]) {
                j ++;
            }
            if (pq[k] < pq[j]) {
                break;
            }
            int temp = pq[k];
            pq[k] = pq[j];
            pq[j] = temp;
            k = j;
        }
        pq[n + 1] = 0;
        return mn;
    }

    public int getMin() {
        return pq[1];
    }

    public int size() {
        return n;
    }
}

/*
 * Complete the 'cookies' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER k
 *  2. INTEGER_ARRAY A
 */
class Result {
    public static int cookies(int k, List<Integer> A) {
        // Write your code here
        PQ pq = new PQ(A.size());
        for (int i = 0; i < A.size(); i++) {
            pq.insert(A.get(i));
        }
        int res = 0;
        while ((pq.size() != 1) && pq.getMin() < k) {
            int one = pq.delMin();
            int two = pq.delMin();
            pq.insert(one + two * 2);
            res ++;
        }
        if (pq.getMin() < k) {
            return -1;
        } else {
            return res;
        }
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> A = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.cookies(k, A);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
