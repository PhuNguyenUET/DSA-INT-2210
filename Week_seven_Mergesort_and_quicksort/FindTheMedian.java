import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'findMedian' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    private static int partition(List<Integer>arr, int l, int h) {
        int i = l, j = h + 1;
        while (true) {
            while (arr.get(++i) < arr.get(l)) {
                if(i == h) {
                    break;
                }
            }
            while (arr.get(l) < arr.get(--j)) {
                if (j == l) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            int tmp = arr.get(i);
            arr.set(i, arr.get(j));
            arr.set(j, tmp);
        }
        int tmp = arr.get(l);
        arr.set(l, arr.get(j));
        arr.set(j, tmp);
        return j;
    }

    public static int findMedian(List<Integer> arr) {
        // Write your code here
        int l = 0, h = arr.size() - 1;
        int k = arr.size() / 2;
        while (h > l) {
            int j = partition(arr, l, h);
            if (j < k) l = j + 1;
            else if (j > k) h = j - 1;
            else return arr.get(k);
        }
        return arr.get(k);
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

        int result = Result.findMedian(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
