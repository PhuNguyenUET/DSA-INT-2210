import java.util.ArrayList;
import java.util.List;

public class CountingSort {
    public static List<Integer> countingSort(List<Integer> arr) {
        // Write your code here
        List<Integer> hash = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            hash.add(0);
        }
        int n = arr.size();
        for (int i = 0; i < n; i++) {
            hash.set(arr.get(i), hash.get(arr.get(i)) + 1);
        }
        return hash;
    }
}
