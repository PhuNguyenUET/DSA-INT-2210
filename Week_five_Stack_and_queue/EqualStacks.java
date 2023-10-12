import java.util.List;
import java.util.Stack;

public class EqualStacks {
    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        // Write your code here
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer>s2 = new Stack<>();
        Stack<Integer>s3 = new Stack<>();

        int n1 = h1.size();
        int sum1 = 0;
        for (int i = n1 - 1; i >= 0; i --) {
            s1.add(h1.get(i));
            sum1 += h1.get(i);
        }

        int n2 = h2.size();
        int sum2 = 0;
        for (int i = n2 - 1; i >= 0; i --) {
            s2.add(h2.get(i));
            sum2 += h2.get(i);
        }

        int n3 = h3.size();
        int sum3 = 0;
        for (int i = n3 - 1; i >= 0; i --) {
            s3.add(h3.get(i));
            sum3 += h3.get(i);
        }

        while (sum1 != sum2 || sum2 != sum3) {
            if (sum1 > sum2 || sum1 > sum3) {
                sum1 -= s1.pop();
            }
            if (sum2 > sum1 || sum2 > sum3) {
                sum2 -= s2.pop();
            }
            if (sum3 > sum1 || sum3 > sum2) {
                sum3 -= s3.pop();
            }
        }
        return sum1;
    }
}
