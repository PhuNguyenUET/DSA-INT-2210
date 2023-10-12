import java.util.Stack;

public class BalancedBrackets {
    public static String isBalanced(String s) {
        // Write your code here
        Stack<Character> st = new Stack<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '{' || c == '[' || c == '(') {
                st.push(c);
                continue;
            }
            if (st.isEmpty() && (c == '}' || c == ']' || c == ')')) {
                return "NO";
            }
            char pop = st.pop();
            if (c == '}' && pop != '{') {
                return "NO";
            }
            if (c == ']' && pop != '[') {
                return "NO";
            }
            if (c == ')' && pop != '(') {
                return "NO";
            }
        }
        if (st.isEmpty()) {
            return "YES";
        } else {
            return "NO";
        }
    }
}
