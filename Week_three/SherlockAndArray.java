import java.util.List;

public class SherlockAndArray {
    // As copied from my work on HackerRank, 'cause I submitted there first
    // And this serve as a sort of homework tracker
    public static String balancedSums(List<Integer> arr) {
        int n = arr.size();
        int sumLeft[] = new int[n + 1];
        sumLeft[0] = 0;
        for (int i = 0; i < n; i++) {
            sumLeft[i + 1] = sumLeft[i] + arr.get(i);
        }
        int sum = sumLeft[n];
        for (int i = 0; i < n; i++) {
            if (sumLeft[i] == sum - arr.get(i) - sumLeft[i]) {
                return "YES";
            }
        }
        return "NO";
    }
}
