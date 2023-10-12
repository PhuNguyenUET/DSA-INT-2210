import java.util.Stack;

public class SimpleTextEditor {
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
