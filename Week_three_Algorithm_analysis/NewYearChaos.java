import java.util.List;

public class NewYearChaos {
    // As copied from my work on HackerRank, 'cause I submitted there first
    // And this serve as a sort of homework tracker
    public static void minimumBribes(List<Integer> q) {
        // Write your code here
        int n = q.size();
        int res = 0;
        int p1 = 1;
        int p2 = 2;
        int p3 = 3;
        for (int i = 0; i < n; i++) {
            if (q.get(i) == p1) {
                p1 = p2;
                p2 = p3;
                p3 ++;
            } else if (q.get(i) == p2) {
                res ++;
                p2 = p3;
                p3 ++;
            } else if (q.get(i) == p3) {
                res += 2;
                p3++;
            } else {
                System.out.println("Too chaotic");
                return;
            }
        }
        System.out.println(res);
    }
}
