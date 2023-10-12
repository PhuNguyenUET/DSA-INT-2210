import edu.princeton.cs.algs4.StdIn;

import java.util.ArrayList;
import java.util.List;

public class LocalMinimum {
    public static int localMinimum (int[] arr) {
        int n = arr.length;
        int l = 0;
        int r = n - 1;

        while (l <= r) {
            int m = l + (r - l)/2;

            if ((m == 0 || arr[m - 1] > arr[m]) && (m == n - 1 || arr[m + 1] > arr[m])) {
                return m;
            } else if (m > 0 && arr[m - 1] < arr[m]) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>();
        while (!StdIn.isEmpty()) {
            int tmp = StdIn.readInt();
            if (tmp == -5) {
                break;
            }
            input.add(tmp);
        }
        int[] inputArray = input.stream().mapToInt(Integer::intValue).toArray();
        System.out.println(localMinimum(inputArray));
    }
}
