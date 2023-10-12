public class SelectionSort {
    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    public static void selectionSort (int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int mn = arr[i];
            int mn_idx = i;
            for (int j = i; j < n; j ++) {
                if (arr[j] < mn) {
                    mn = arr[j];
                    mn_idx = j;
                }
            }
            swap (arr, i, mn_idx);
        }
    }
}
