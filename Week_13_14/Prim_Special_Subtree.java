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

    /*
     * Complete the 'prims' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY edges
     *  3. INTEGER start
     */

    private static boolean[] marked;
    private static PriorityQueue<Edge> pq = new PriorityQueue<>();
    private static List<Edge>[] adj;

    public static int prims(int n, List<List<Integer>> edges, int start) {
        // Write your code here
        int res = 0;
        adj = (ArrayList<Edge>[]) new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Edge>();
        }
        for (int i = 0; i < edges.size(); i++) {
            int v = edges.get(i).get(0) - 1;
            int w = edges.get(i).get(1) - 1;
            Edge e = new Edge(edges.get(i).get(2), v, w);
            adj[v].add(e);
            adj[w].add(e);
        }
        marked = new boolean[n];
        visit(start - 1);
        while(!pq.isEmpty()) {
            Edge e = pq.poll();
            if (marked[e.v] && marked[e.w]) {
                continue;
            } else {
                res += e.r;
                if(!marked[e.v]) {
                    visit(e.v);
                } else {
                    visit(e.w);
                }
            }
        }
        return res;
    }

    private static void visit(int v) {
        marked[v] = true;
        for (Edge e : adj[v]) {
            if (!marked[e.other(v)]) {
                pq.add(e);
            }
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> edges = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                edges.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int start = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.prims(n, edges, start);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
