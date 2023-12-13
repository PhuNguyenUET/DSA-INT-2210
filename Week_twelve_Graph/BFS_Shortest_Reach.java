import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int[] findShortestReach(ArrayList<ArrayList<Integer>> graph, int start) {
        int[] costs = new int[graph.size()];
        int UNIT_COST = 6;
        boolean[] visited = new boolean[graph.size()];
        for (int i = 0; i < costs.length; ++i) costs[i] = -1;

        Queue<Integer> q = new LinkedList<Integer>();
        q.add(start);
        visited[start] = true;
        costs[start] = 0;
        while (!q.isEmpty()) {
            int v = q.poll();
            for (int w : graph.get(v)) {
                if(!visited[w]) {
                    q.add(w);
                    visited[w]= true;
                    costs[w] = costs[v] + 6;
                }
            }
        }

        return costs;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int Q = scanner.nextInt();
        for (int q = 0; q < Q; ++q) {
            int N, M, start;
            N = scanner.nextInt();
            M = scanner.nextInt();
            ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
            for (int i = 0; i <= N; ++i) {
                graph.add(new ArrayList<Integer>());
            }
            for (int i = 0; i < M; ++i) {
                int n1, n2;
                n1 = scanner.nextInt();
                n2 = scanner.nextInt();
                graph.get(n1).add(n2);
                graph.get(n2).add(n1);
            }
            start = scanner.nextInt();
            int[] costs = findShortestReach(graph, start);
            for (int i = 1; i < costs.length; ++i) {
                if (i == start) continue;
                System.out.print(costs[i] + " ");
            }
            System.out.println();
        }
    }
}
