import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class UF2 {
    private int[] root;
    public UF2 (int n){
        root = new int[n];
        for (int i = 1; i <= n; i++) {
            root[i] = -1;
        }
    }
    public int get(int u) {
        if (root[u] < 0) return u;
        return root[u] = get(root[u]);
    }

    public int find (int p) {
        while (root[p] > 0) {
            p = root[p];
        }
        return p;
    }

    public boolean isConnected(int p, int q) {
        int parent_p = find(p);
        int parent_q = find(q);
        if (parent_p != parent_q) {
            return false;
        } else {
            return true;
        }
    }

    public void join(int u, int v) {
        int p = get(u), q = get(v);
        if (p != q) {
            if (root[p] <= root[q]) {
                root[p] += root[q];
                root[q] = p;
            } else {
                root[q] += root[p];
                root[p] = q;
            }
        }
    }

}
