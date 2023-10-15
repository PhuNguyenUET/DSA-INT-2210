import java.util.List;

public class Quicksort_Partition {
    public static List<Integer> quickSort(List<Integer> arr) {
        // Write your code here
        int l = 0;
        int h = arr.size() - 1;
        int lt = l, gt = h;
        int v = arr.get(l);
        int i = l;
        while (i <= gt) {
            if (arr.get(i) < v) {
                int tmp = arr.get(lt);
                arr.set(lt, arr.get(i));
                arr.set(i, tmp);
                lt ++;
                i ++;
            } else if (arr.get(i) > v) {
                int tmp = arr.get(i);
                arr.set(i, arr.get(gt));
                arr.set (gt, tmp);
                gt --;
            } else {
                i ++;
            }
        }
        return arr;
    }
}
