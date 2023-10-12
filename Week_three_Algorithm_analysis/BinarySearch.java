import edu.princeton.cs.algs4.*;

import java.util.*;

public class BinarySearch {
    public static int binarySearch (int[] a, int number) {
        int l = 0;
        int h = a.length - 1;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (number < a[m]) {
                h = m - 1;
            } else if (number > a[m]) {
                l = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>();
        while (!StdIn.isEmpty()) {
            input.add(StdIn.readInt());
        }
        Collections.sort(input);
        int num = input.get((int)(Math.random() * input.size()));
        int[] inputArray = input.stream().mapToInt(Integer::intValue).toArray();
        System.out.println(binarySearch(inputArray, num));
    }
}
