public class UnionFindDemo {    
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        int res = n;
        int[] roots = new int[n];
        for (int i = 0; i < n; i ++) {
            roots[i] = i;
        }

        int k = 2;
        int h = 3;
        int x;
        int y;

        for (int i = 0; i < m; i++) {
            x = Integer.parseInt(args[k]);
            y = Integer.parseInt(args[h]);
            k += 2;
            h += 2;
            int root_x = roots[x];
            int root_y = roots[y];
            if (root_x != root_y) { 
                res --;
                for (int j = 0; j < n; j++) {
                    if (roots[j] == root_x) {
                        roots[j] = root_y;
                    }
                }
            }
        }
        System.out.println(res);
    }
}