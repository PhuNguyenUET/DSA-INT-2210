import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        /* Enter your code here. Print output to STDOUT. */
        int n = A.length();
        for (int i = 0; i <= n/2; i++) {
            if (A.charAt(i) != A.charAt(n - i - 1)) {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }
}



