import edu.princeton.cs.algs4.StdIn;

import java.util.*;

public class FourSum {
    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>();
        while (!StdIn.isEmpty()) {
            input.add(StdIn.readInt());
        }
        Collections.sort(input);
        int n = input.size();
        for (int i = 0; i < n - 3; i++) {
            Map<Integer, Integer> hash = new HashMap<>();
            for (int j = i + 1; j < n - 2; j ++) {
                for (int k = j + 1; k < n - 1; k ++) {
                    int tmp = input.get(k);
                    int count = hash.getOrDefault(tmp, 0);
                    int other = -input.get(i) - input.get(j) - tmp;
                    if (hash.containsKey(other)) {
                        for (int m = 0; m < hash.get(other); m++) {
                            System.out.println(input.get(i) + " " + input.get(j) + " " + tmp + " " + other);
                        }
                    }
                    hash.put(tmp, count + 1);
                }
            }
        }
    }
}
