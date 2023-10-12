import edu.princeton.cs.algs4.*;

import java.util.*;

public class TwoSum {
    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>();
        Map<Integer, Integer> hash = new HashMap<>();
        while (!StdIn.isEmpty()) {
            input.add(StdIn.readInt());
        }
        for (int tmp : input) {
            int count = hash.getOrDefault(tmp, 0);
            hash.put(tmp, count + 1);
            if (hash.containsKey(-tmp)) {
                for (int j = 0; j < hash.get(-tmp); j++) {
                    System.out.println(tmp + " " + -tmp);
                }
            }
        }
    }
}
