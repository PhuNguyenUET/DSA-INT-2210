import java.io.*;
import java.util.*;

class Node {
    int val;
    Node left;
    Node right;
    int height = 0;
    Node() {}
    Node(int val) {
        this.val = val;
    }
    Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class AVLTree {
    public Node root;

    private int getHeight(Node n) {
        int left = n.left == null? -1 : n.left.height;
        int right = n.right == null? -1 : n.right.height;
        return Math.max(left, right) + 1;
    }

    public int getBalanceFactor(Node n) {
        if (n == null) {
            return 0;
        }
        int left = n.left == null? -1 : n.left.height;
        int right = n.right == null? -1 : n.right.height;
        return left - right;
    }

    private Node rotateLeft(Node x) {
        Node y = x.right;
        x.right = y.left;
        y.left = x;
        x.height = getHeight(x);
        y.height = getHeight(y);
        return y;
    }

    private Node rotateRight(Node x) {
        Node y = x.left;
        x.left = y.right;
        y.right = x;
        x.height = getHeight(x);
        y.height = getHeight(y);
        return y;
    }

    public void insert(int val) {
        root = insert(root, val);
    }

    private Node insert(Node root, int val) {
        if(root == null) {
            return new Node(val);
        }
        if (val > root.val) {
            root.right = insert(root.right, val);
        } else if (val < root.val) {
            root.left = insert(root.left, val);
        } else {
            return root;
        }
        root.height = getHeight(root);
        if (getBalanceFactor(root) > 1) {
            if (getBalanceFactor(root.left) < 0) {
                root.left = rotateLeft(root.left);
            }
            if (getBalanceFactor(root.left) >= 0) {
                root = rotateRight(root);
            }
        } else if (getBalanceFactor(root) < -1) {
            if (getBalanceFactor(root.right) > 0) {
                root.right = rotateRight(root.right);
            }
            if (getBalanceFactor(root.right) <= 0) {
                root = rotateLeft(root);
            }
        }
        return root;
    }

    public void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + "(BF=" + getBalanceFactor(root) + ") ");
        inorder(root.right);
    }

    public void preorder(Node root) {
        if (root == null) return;
        System.out.print(root.val + "(BF=" + getBalanceFactor(root) + ") ");
        preorder(root.left);
        preorder(root.right);
    }
}

public class Solution {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        AVLTree tree = new AVLTree();
        for (int i = 0; i < n; i++) {
            tree.insert(sc.nextInt());
        }
        tree.insert(sc.nextInt());
        tree.inorder(tree.root);
        System.out.println();
        tree.preorder(tree.root);
    }
}