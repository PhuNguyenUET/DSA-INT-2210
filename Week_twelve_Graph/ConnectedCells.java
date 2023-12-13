import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Cell {
    public int r, c;
    public Cell(int i, int j) {
        r = i;
        c = j;
    }
}

public class Solution {

    static int[][] grid;
    static boolean[][] visited;
    static int N, M;

    static int count_connected(int row, int col) {
        int cnt = 1;

        visited[row][col] = true;
        for(int i = Math.max(row - 1, 0); i <= Math.min(row + 1, N - 1); i++) {
            for(int j = Math.max(col - 1, 0); j <= Math.min(col + 1, M - 1); j++) {
                if(!visited[i][j] && grid[i][j] == 1) {
                    cnt += count_connected(i, j);
                }
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        grid = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                grid[i][j] = scanner.nextInt();
                visited[i][j] = false;
            }
        }
        int max = 0;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (grid[i][j] == 0 || visited[i][j]) continue;
                int cnt = count_connected(i, j);
                if (max < cnt) max = cnt;
            }
        }

        System.out.println(max);

    }
}
