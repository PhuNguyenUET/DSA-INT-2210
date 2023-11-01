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
    private int pq[] = new int[10000000];
    int size = 0;

    private void exchange (int i, int j) {
        int tmp = pq[i];
        pq[i] = pq[j];
        pq[j] = tmp;
    }

    public void insert(int k) {
        size ++;
        pq[size] = k;
        int tmp = size;
        while (tmp > 1 && pq[tmp/2] > pq[tmp]) {
            exchange(tmp, tmp/2);
            tmp /= 2;
        }
    }

    public int delMin() {
        int mn = pq[1];
        exchange(1, size);
        pq[size] = 0;
        size --;

        int tmp = 1;

        while(2 * tmp <= size) {
            int smaller;
            if (2 * tmp + 1 <= size && pq[2 * tmp] > pq[2 * tmp + 1]) {
                smaller = 2 * tmp + 1;
            } else {
                smaller = 2 * tmp;
            }
            if (pq[tmp] < pq[smaller]) {
                break;
            }
            exchange(tmp, smaller);
            tmp = smaller;
        }

        return mn;
    }

    public int getMin() {
        return pq[1];
    }

    public int size() {
        return size ;
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
        PQ pq = new PQ();
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
