import java.util.Scanner;

public class QuickSortDumb {
    private static int partition (int[] a, int l, int h) {
        int pivot = a[h];
        int i = l;
        for (int j = l; j <= h - 1; j++) {
            if (a[j] <= pivot) {
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
                i = i + 1;
            }
        }
        int tmp = a[i];
        a[i] = a[h];
        a[h] = tmp;
        return i;
    }

    public static void sort (int[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(int[] a, int l, int h) {
        if (h <= l) {
            return;
        }
        int j = partition(a, l, h);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        sort(a, l, j - 1);
        sort(a, j + 1, h);
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        try {
            int num = scanner.nextInt();
            int a[] = new int[num];
            for (int i = 0; i < num; i++) {
                a[i] = scanner.nextInt();
            }
            sort(a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
