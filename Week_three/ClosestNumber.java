import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClosestNumber {
    // As copied from my work on HackerRank, 'cause I submitted there first
    // And this serve as a sort of homework tracker
    public static List<Integer> closestNumbers(List<Integer> arr) {
        Collections.sort(arr);
        List<Integer>res = new ArrayList<>();
        int n = arr.size();
        int mn = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            if(Math.abs(arr.get(i) - arr.get(i + 1)) < mn) {
                mn = Math.abs(arr.get(i) - arr.get(i + 1));
            }
        }
        for (int i = 0; i < n - 1; i++) {
            if (Math.abs(arr.get(i) - arr.get(i + 1)) == mn) {
                res.add(arr.get(i));
                res.add(arr.get(i + 1));
            }
        }
        return res;
    }
}
