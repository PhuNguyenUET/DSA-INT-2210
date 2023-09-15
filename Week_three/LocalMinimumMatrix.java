public class LocalMinimumMatrix {
    public int localMinimumMatrix (int[][] arr) {
        int n = arr.length;
        int mn = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        for (int k = 0; k < n; k++) {
            if (arr[k][n/2] < mn) {
                mn = arr[k][n/2];
                i = k;
                j = n/2;
            }
        }
        for (int k = 0; k < n; k++) {
            if (arr[n/2][k] < mn) {
                mn = arr[n/2][k];
                i = n/2;
                j = k;
            }
        }
        while (true) {
            int cur = arr[i][j];
            int up = i == 0? Integer.MAX_VALUE : arr[i - 1][j];
            int down = i == n - 1? Integer.MAX_VALUE : arr[i + 1][j];
            int left = j == 0? Integer.MAX_VALUE : arr[i][j - 1];
            int right = j == n - 1? Integer.MAX_VALUE : arr[i][j + 1];
            if (cur < up && cur < down && cur < left && cur < right) {
                return cur;
            }
            if (up > down && up > left && up > right) {
                i--;
            } else if (down > up && down > left && down > right) {
                i ++;
            } else if (left > up && left > down && left > right) {
                j --;
            } else if (right > up && right > down && right > left) {
                j ++;
            }
        }
    }
}
