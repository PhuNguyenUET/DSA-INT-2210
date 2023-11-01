import java.io.*;
import java.util.*;

class TextEditor {
    StringBuilder s = new StringBuilder();
    Stack<String> st = new Stack<>();

    void append (String str) {
        st.add(s.toString());
        s.append(str);
    }

    void delete (int k) {
        int n = s.length();
        st.add(s.toString());
        s.delete(n - k, n);
    }

    void print (int idx) {
        System.out.println(s.charAt(idx - 1));
    }

    void undo () {
        s = new StringBuilder(st.pop());
    }
}

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        TextEditor txt = new TextEditor();
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int t = scanner.nextInt();
            if (t == 1) {
                String str = scanner.next();
                txt.append(str);
            } else if (t == 2) {
                int x = scanner.nextInt();
                txt.delete(x);
            } else if (t == 3){
                int x = scanner.nextInt();
                txt.print(x);
            } else {
                txt.undo();
            }
        }
    }
}
