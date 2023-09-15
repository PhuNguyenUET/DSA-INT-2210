import edu.princeton.cs.algs4.*;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>();
        while (!StdIn.isEmpty()) {
            input.add(StdIn.readInt());
        }
        Collections.sort(input);
        int n = input.size();
        for (int i = 0; i < n - 2; i++) {
            Map<Integer, Integer> hash = new HashMap<>();
            for (int j = i + 1; j <= n - 1; j ++) {
                int tmp = input.get(j);
                int count = hash.getOrDefault(tmp, 0);
                int other = -input.get(i)-tmp;
                if (hash.containsKey(other)) {
                    for (int k = 0; k < hash.get(other); k++) {
                        System.out.println(input.get(i) + " " + tmp + " " + other);
                    }
                }
                hash.put(tmp, count + 1);
            }
        }
    }
}
