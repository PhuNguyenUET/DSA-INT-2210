import java.util.List;

public class TutorialIntro {
    public static int introTutorial(int V, List<Integer> arr) {
        // Write your code here
        int l = 0;
        int h = arr.size() - 1;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (V < arr.get(m)) {
                h = m - 1;
            } else if (V > arr.get(m)) {
                l = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }
}
