import edu.princeton.cs.algs4.StdIn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BitonicSearch {
    public static int binarySearch(int[] arr, int l, int r, int target) {
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (target < arr[m]) {
                r = m - 1;
            } else if (target > arr[m]) {
                l = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }public static int binarySearchReverse(int[] arr, int l, int r, int target) {
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (target < arr[m]) {
                l = m + 1;
            } else if (target > arr[m]) {
                r = m - 1;
            } else {
                return m;
            }
        }
        return -1;
    }
    public static int bitonicSearch (int[] arr, int target) {
        int n = arr.length;
        int l = 0;
        int r = n - 1;
        int m = 0;
        while (l <= r) {
            m = l + (r - l)/2;

            if ((m == 0 || arr[m - 1] < arr[m]) && (m == n - 1 || arr[m + 1] < arr[m])) {
                break;
            } else if (m > 0 && arr[m - 1] > arr[m]) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        int leftHalf = binarySearch(arr, 0, m, target);
        int rightHalf = binarySearchReverse(arr, m, n - 1, target);
        if (leftHalf != -1) {
            return leftHalf;
        } else if (rightHalf != -1) {
            return rightHalf;
        } else {
            return -1;
        }
    }
    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>();
        while (!StdIn.isEmpty()) {
            int tmp = StdIn.readInt();
            input.add(tmp);
        }
        int[] inputArray = input.stream().mapToInt(Integer::intValue).toArray();
        System.out.println(bitonicSearch(inputArray, 7));
    }
}
