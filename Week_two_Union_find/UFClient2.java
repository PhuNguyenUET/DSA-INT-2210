import edu.princeton.cs.algs4.*;
public class UFClient2 {
    public static void main(String[] args) {
        int N = StdIn.readInt();
        int idx = 0;
        boolean pass = false;
        UF uf = new UF(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            idx ++;
            if (!uf.connected(p, q)) {
                uf.union(p, q);
            }
            if (uf.count() == 1) {
                pass = true;
                break;
            }
        }
        if (!pass) {
            System.out.println("FAILED");
        } else {
            System.out.println(idx);
        }
    }
}
