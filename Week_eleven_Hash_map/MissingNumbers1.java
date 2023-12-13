import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'missingNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arr
     *  2. INTEGER_ARRAY brr
     */

    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
        // Write your code here
        List<Integer> lst = new ArrayList<>();
        Map<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < arr.size(); i++) {
            int tmp = hash.getOrDefault(arr.get(i), 0);
            hash.put(arr.get(i), tmp + 1);
        }
        for (int i = 0; i < brr.size(); i++) {
            if (!hash.containsKey(brr.get(i))) {
                lst.add(brr.get(i));
            } else {
                if (hash.get(brr.get(i)) == 0 && !lst.contains(brr.get(i))) {
                    lst.add(brr.get(i));
                    continue;
                }
                hash.put(brr.get(i), hash.get(brr.get(i)) - 1);
            }
        }
        Collections.sort(lst);
        return lst;
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

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.missingNumbers(arr, brr);

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
