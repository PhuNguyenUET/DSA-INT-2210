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

class Merge {
    private static void merge(List<Integer> a, List<Integer> aux, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++) {
            aux.set(k, a.get(k));
        }

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a.set(k, aux.get(j++));
            else if (j > hi) a.set(k, aux.get(i++));
            else if (aux.get(j) < aux.get(i)) a.set(k, aux.get(j++));
            else a.set(k, aux.get(i++));
        }
    }

    private static void sort (List<Integer>a, List<Integer> aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort (a, aux, lo, mid);
        sort (a, aux, mid+1, hi);
        merge(a, aux, lo, mid, hi);
    }

    public static void sort (List<Integer>a) {
        List<Integer>aux = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            aux.add(0);
        }
        sort(a, aux, 0, a.size() - 1);
    }
}

class Result {

    /*
     * Complete the 'closestNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    public static List<Integer> closestNumbers(List<Integer> arr) {
        // Write your code here
        Merge.sort(arr);
        List<Integer>res = new ArrayList<>();
        int n = arr.size();
        int mn = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            if(Math.abs(arr.get(i) - arr.get(i + 1)) < mn) {
                mn = Math.abs(arr.get(i) - arr.get(i + 1));
            }
        }
        for (int i = 0; i < n - 1; i++) {
            if (Math.abs(arr.get(i) - arr.get(i + 1)) == mn) {
                res.add(arr.get(i));
                res.add(arr.get(i + 1));
            }
        }
        return res;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.closestNumbers(arr);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
