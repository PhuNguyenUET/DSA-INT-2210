public class UnionFind {
    private int[] parent;
    int count;
    public UnionFind (int n) {
        count = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = -1;
        }
    }

    public int find (int p) {
        while (parent[p] >= 0) {
            if (parent[parent[p]] >= 0) {
                parent[p] = parent[parent[p]];
            }
            p = parent[p];
        }
        return p;
    }

    public int findSize (int p) {
        while (parent[p] >= 0) {
            p = parent[p];
        }
        return parent[p];
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void union (int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        int sizeP = findSize(p);
        int sizeQ = findSize(q);
        if (rootP == rootQ) {
            return;
        }
        if (sizeP <= sizeQ) {
            parent[rootP] += parent[rootQ];
            parent[rootQ] = rootP;
        } else {
            parent[rootQ] += parent[rootP];
            parent[rootP] = rootQ;
        }
        count --;
    }
}
