import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SegmentationTree {
    static List<Integer> lst = new ArrayList<>();
    static int[] tree = new int[Integer.MAX_VALUE];

    public static void build(int l, int r, int id) {
        if (l == r) {
            tree[id] = lst.get(l);
            return;
        }
        int m = l + (r - l)/2;
        build(l, m, 2 * id);
        build(m + 1, r, 2 * id + 1);
        tree[id] = Math.max(tree[2 * id], tree[2 * id + 1]);
    }

    public static int get(int l, int r, int id, int u, int v) {
        if (v < l || r < u) {
            return Integer.MIN_VALUE;
        }
        if (u <= l && r <= v) {
            return tree[id];
        }
        int m = l + (r - l)/2;
        int left = get(l, m, 2 * id, u, v);
        int right = get(m + 1, r, 2 * id + 1, u, v);
        return Math.max(left, right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            lst.add(sc.nextInt());
        }
        build(1, n, 1);
        for (int i = 1; i <= m; i++) {
            int l, r;
            l = sc.nextInt();
            r = sc.nextInt();
            System.out.println(get(1, n, 1, l, r));
        }
    }
}
