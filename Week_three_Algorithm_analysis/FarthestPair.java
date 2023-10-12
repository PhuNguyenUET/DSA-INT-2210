import edu.princeton.cs.algs4.StdIn;

import java.util.ArrayList;
import java.util.List;

public class FarthestPair {
    public static void farthestPair (int[] a) {
        int mn = Integer.MAX_VALUE;
        int mx = Integer.MIN_VALUE;
        for (int number : a) {
            if (number < mn) {
                mn = number;
            } else if (number > mx) {
                mx = number;
            }
        }
        System.out.println(mn + " " + mx);
    }

    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>();
        while (!StdIn.isEmpty()) {
            int tmp = StdIn.readInt();
            input.add(tmp);
        }
        int[] inputArray = input.stream().mapToInt(Integer::intValue).toArray();
        farthestPair(inputArray);
    }
}
