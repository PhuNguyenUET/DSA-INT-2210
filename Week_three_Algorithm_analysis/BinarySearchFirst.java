import edu.princeton.cs.algs4.StdIn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BinarySearchFirst {
    public static int binarySearch (int[] a, int number) {
        int l = 0;
        int h = a.length - 1;
        int res = -1;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (number < a[m]) {
                h = m - 1;
            } else if (number > a[m]) {
                l = m + 1;
            } else {
                res = m;
                h = m - 1;
            }
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
        Arrays.sort(inputArray);
        System.out.println(binarySearch(inputArray, 2));
    }
}
