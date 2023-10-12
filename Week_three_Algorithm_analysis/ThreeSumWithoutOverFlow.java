import edu.princeton.cs.algs4.*;

import java.util.Arrays;

public class ThreeSumWithoutOverFlow {
        public static int count(int[] a) {
            int n = a.length;
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i+1; j < n; j++) {
                    for (int k = j+1; k < n; k++) {
                        int b = a[i];
                        int c = a[j];
                        int d = a[k];
                        if ((b > 0 && c > 0 && d > 0) || (b < 0 && c < 0 && d < 0)) {
                            continue;
                        }
                        int[] tmp = new int[3];
                        tmp[0] = b;
                        tmp[1] = c;
                        tmp[2] = d;
                        Arrays.sort(tmp);
                        if (tmp[1] > 0) {
                            int sumTwo = tmp[0] + tmp[1];
                            if (sumTwo > 0) {
                                continue;
                            } else if (sumTwo + tmp[2] == 0){
                                count ++;
                            }
                        } else {
                            int sumTwo = tmp[2] + tmp[1];
                            if (sumTwo < 0) {
                                continue;
                            } else if (sumTwo + tmp[0] == 0){
                                count ++;
                            }
                        }
                    }
                }
            }
            return count;
        }
}
