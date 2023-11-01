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
     * Complete the 'equalStacks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY h1
     *  2. INTEGER_ARRAY h2
     *  3. INTEGER_ARRAY h3
     */

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        // Write your code here
        Stack<Integer>s1 = new Stack<>();
        Stack<Integer>s2 = new Stack<>();
        Stack<Integer>s3 = new Stack<>();

        int n1 = h1.size();
        int sum1 = 0;
        for (int i = n1 - 1; i >= 0; i --) {
            s1.add(h1.get(i));
            sum1 += h1.get(i);
        }

        int n2 = h2.size();
        int sum2 = 0;
        for (int i = n2 - 1; i >= 0; i --) {
            s2.add(h2.get(i));
            sum2 += h2.get(i);
        }

        int n3 = h3.size();
        int sum3 = 0;
        for (int i = n3 - 1; i >= 0; i --) {
            s3.add(h3.get(i));
            sum3 += h3.get(i);
        }

        while (sum1 != sum2 || sum2 != sum3) {
            if (sum1 > sum2 || sum1 > sum3) {
                sum1 -= s1.pop();
            }
            if (sum2 > sum1 || sum2 > sum3) {
                sum2 -= s2.pop();
            }
            if (sum3 > sum1 || sum3 > sum2) {
                sum3 -= s3.pop();
            }
        }
        return sum1;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n1 = Integer.parseInt(firstMultipleInput[0]);

        int n2 = Integer.parseInt(firstMultipleInput[1]);

        int n3 = Integer.parseInt(firstMultipleInput[2]);

        List<Integer> h1 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> h2 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> h3 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.equalStacks(h1, h2, h3);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
