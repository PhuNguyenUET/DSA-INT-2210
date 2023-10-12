import edu.princeton.cs.algs4.StdIn;

import java.util.*;

public class EqualPairs {
    public static int equalPairs (int[] input) {
        int n = input.length;
        int res = 0;
        Map<Integer, Integer> hash = new HashMap<>();
        for (int j : input) {
            int count = hash.getOrDefault(j, 0);
            if (count > 0) {
                res += count;
            }
            hash.put(j, count + 1);
        }
        return res;
    }
    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>();
        while (!StdIn.isEmpty()) {
            int tmp = StdIn.readInt();
            input.add(tmp);
        }
        int[] inputArray = input.stream().mapToInt(Integer::intValue).toArray();
        System.out.println(equalPairs(inputArray));
    }
}
