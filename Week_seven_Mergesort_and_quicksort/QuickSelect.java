import java.util.List;

public class QuickSelect {
    private static int partition(List<Integer>arr, int l, int h) {
        int i = l, j = h + 1;
        while (true) {
            while (arr.get(++i) < arr.get(l)) {
                if(i == h) {
                    break;
                }
            }
            while (arr.get(l) < arr.get(--j)) {
                if (j == l) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            int tmp = arr.get(i);
            arr.set(i, arr.get(j));
            arr.set(j, tmp);
        }
        int tmp = arr.get(l);
        arr.set(l, arr.get(j));
        arr.set(j, tmp);
        return j;
    }

    public static int findMedian(List<Integer> arr) {
        // Write your code here
        int l = 0, h = arr.size() - 1;
        int k = arr.size() / 2;
        while (h > l) {
            int j = partition(arr, l, h);
            if (j < k) l = j + 1;
            else if (j > k) h = j - 1;
            else return arr.get(k);
        }
        return arr.get(k);
    }
}
