import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pairs {
    // As copied from my work on HackerRank, 'cause I submitted there first
    // And this serve as a sort of homework tracker
    public static int pairs(int k, List<Integer> arr) {
        // Write your code here
        int res = 0;
        Collections.sort(arr);
        Map<Integer, Integer> hash = new HashMap<>();
        for (int tmp : arr) {
            int count = hash.getOrDefault(tmp, 0);
            hash.put(tmp, count + 1);
            if (hash.containsKey(tmp - k)) {
                res += hash.get(tmp - k);
            }
        }
        return res;
    }
}
