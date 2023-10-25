import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {

    /*
    
    class Node 
        int data;
        Node left;
        Node right;
    */
    public static void levelOrder(Node root, List<List<Integer>> levels, int curLev) {
        if (root == null) {
            return;
        }
        if(levels.size() <= curLev) {
            levels.add(new ArrayList<>());
        }
        levels.get(curLev).add(root.data);
        levelOrder(root.left, levels, curLev + 1);
        levelOrder(root.right, levels, curLev + 1);
    }
    public static void levelOrder(Node root) {
        List<List<Integer>> levels = new ArrayList<>();
        levelOrder(root, levels, 0);
        for (int i = 0; i < levels.size(); i++) {
            for (int j = 0; j < levels.get(i).size(); j++) {
                System.out.print(levels.get(i).get(j) + " ");
            }
        }
    }

    public static Node insert(Node root, int data) {
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
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        levelOrder(root);
    }
}