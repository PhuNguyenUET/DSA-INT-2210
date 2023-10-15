public class PriorityQueue {
    private int[] pq;
    private int n;
    public PriorityQueue(int capacity) {
        pq = new int[capacity + 1];
    }
    public boolean isEmpty() {
        return n == 0;
    }

    private void swim (int k) {
        while (k > 1 && pq[k/2] < pq[k]) {
            int tmp = pq[k/2];
            pq[k/2] = pq[k];
            pq[k] = tmp;
            k = k/2;
        }
    }

    private void sink(int k) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && pq[j] < pq[j + 1]) {
                j ++;
            }
            if (pq[k] > pq[j]) {
                break;
            }
            int tmp = pq[k];
            pq[k] = pq[j];
            pq[j] = tmp;
            k = j;
        }
    }

    public void insert(int key) {
        pq[++ n] = key;
        swim(n);
    }

    public int delMax () {
        int max = pq[1];
        int tmp = pq[1];
        pq[1] = pq[n];
        pq[n] = tmp;
        n --;
        sink(1);
        pq[n + 1] = 0;
        return max;
    }
}
