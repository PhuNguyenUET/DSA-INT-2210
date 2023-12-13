import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
class Node {
    Node left;
    Node right;
    int data;
    int size = 1;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class BST {
    Node root;

    /*
    class Node
        int data;
        Node left;
        Node right;
    */
    public int size(Node root) {
        // Write your code here.
        int res = 0;
        if (root == null) {
            return res;
        }
        int l = (root.left == null? 0 : root.left.size);
        int r = root.right == null? 0 : root.right.size;
        res = l + r + 1;
        return res;
    }

    public void insert(int data) {
        root = insert(root, data);
    }

    private Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            root.size = size(root);
            return root;
        }
    }

    public double findMedian() {
        int sz = root.size;
        if (sz % 2 == 1) {
            return findID(root, sz / 2 + 1);
        } else {
            return (findID(root, sz/2) + findID(root, sz/2 + 1)) / 2;
        }
    }

    private double findID(Node root, int id) {
        if (root == null) {
            return -1;
        }
        int sz = root.left == null? 0 : root.left.size;
        if (id <= sz) {
            return findID(root.left, id);
        } else if (id == sz + 1) {
            return root.data;
        } else {
            return findID(root.right, id - sz - 1);
        }
    }
}

class Result {

    /*
     * Complete the 'runningMedian' function below.
     *
     * The function is expected to return a DOUBLE_ARRAY.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static List<Double> runningMedian(List<Integer> a) {
        // Write your code here
        List<Double> res = new ArrayList<>();
        BST tree = new BST();
        for (int i = 0; i < a.size(); i++) {
            tree.insert(a.get(i));
            res.add(tree.findMedian());
        }
        return res;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int aCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = IntStream.range(0, aCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<Double> result = Result.runningMedian(a);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
