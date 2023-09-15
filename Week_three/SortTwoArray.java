public class SortTwoArray {
    public static void sortTwoArray (int[] arr1, int[] arr2) {
        int ptr1 = 0;
        int ptr2 = 0;
        int n1 = arr1.length;
        int n2 = arr2.length;
        while (ptr1 < n1 && ptr2 < n2) {
            if (arr1[ptr1] <= arr2[ptr2]) {
                System.out.print(arr1[ptr1]);
                System.out.print(" ");
                ptr1 ++;
            } else {
                System.out.print(arr2[ptr2]);
                System.out.print(" ");
                ptr2 ++;
            }
        }
        if (ptr1 == n1) {
            for (int i = ptr2; i < n2; i++) {
                System.out.print(arr2[i]);
                System.out.print(" ");
            }
        } else {
            for (int i = ptr1; i < n1; i++) {
                System.out.print(arr1[i]);
                System.out.print(" ");
            }
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 6, 8, 9};
        int[] arr2 = {0, 2, 3, 4, 5, 7, 8, 9, 11};
        sortTwoArray(arr1, arr2);
    }
}
