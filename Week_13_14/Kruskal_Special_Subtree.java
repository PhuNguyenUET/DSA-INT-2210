import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class UnionFind {
    private int[] id;
    private int[] sz;

    public UnionFind(int n) {
        id = new int[n];
        sz = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    public int find (int i) {
        while (i != id[i]) {
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) {
            return;
        }
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
    }
}

class Edge implements Comparable<Edge> {
    public int r, v, w;
    public Edge(int cost, int v, int w) {
        r = cost;
        this.v = v;
        this.w = w;
    }
    public int other(int vertex) {
        if (vertex == v) return w;
        else return v;
    }
    @Override
    public int compareTo(Edge c) {
        if (r < c.r) return -1;
        if (r > c.r) return 1;
        return 0;
    }
}

class Result {
    private static PriorityQueue<Edge> pq = new PriorityQueue<>();
    /*
     * Complete the 'kruskals' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts WEIGHTED_INTEGER_GRAPH g as parameter.
     */

    /*
     * For the weighted graph, <name>:
     *
     * 1. The number of nodes is <name>Nodes.
     * 2. The number of edges is <name>Edges.
     * 3. An edge exists between <name>From[i] and <name>To[i]. The weight of the edge is <name>Weight[i].
     *
     */

    public static int kruskals(int gNodes, List<Integer> gFrom, List<Integer> gTo, List<Integer> gWeight) {
        int res = 0;
        for (int i = 0; i < gTo.size(); i++) {
            int v = gFrom.get(i) - 1;
            int w = gTo.get(i) - 1;
            Edge e = new Edge(gWeight.get(i), v, w);
            pq.add(e);
        }
        UnionFind uf = new UnionFind(gNodes);
        while(!pq.isEmpty()) {
            Edge e = pq.poll();
            if (!uf.connected(e.v, e.w)) {
                res += e.r;
                uf.union(e.v, e.w);
            }
        }
        return res;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] gNodesEdges = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int gNodes = Integer.parseInt(gNodesEdges[0]);
        int gEdges = Integer.parseInt(gNodesEdges[1]);

        List<Integer> gFrom = new ArrayList<>();
        List<Integer> gTo = new ArrayList<>();
        List<Integer> gWeight = new ArrayList<>();

        IntStream.range(0, gEdges).forEach(i -> {
            try {
                String[] gFromToWeight = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                gFrom.add(Integer.parseInt(gFromToWeight[0]));
                gTo.add(Integer.parseInt(gFromToWeight[1]));
                gWeight.add(Integer.parseInt(gFromToWeight[2]));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int res = Result.kruskals(gNodes, gFrom, gTo, gWeight);

        // Write your code here.
        bufferedWriter.write(String.valueOf(res));
        bufferedReader.close();
        bufferedWriter.close();
    }
}
