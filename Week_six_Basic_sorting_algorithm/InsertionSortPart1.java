import java.util.List;

public class InsertionSortPart1 {
    public static void insertionSort1(int n, List<Integer> arr) {
        // Write your code here
        int tmp = arr.get(n - 1);
        int idx = n - 1;
        while (idx > 0 && arr.get(idx - 1) > tmp) {
            arr.set(idx, arr.get(idx - 1));
            for (int i = 0; i < n; i++) {
                System.out.print(arr.get(i) + " ");
            }
            System.out.println();
            idx --;
        }
        arr.set(idx, tmp);
        for (int i = 0; i < n; i++) {
            System.out.print(arr.get(i) + " ");
        }
    }
}
