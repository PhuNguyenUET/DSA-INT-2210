/* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.  

The Node class is defined as follows:
    class Node {
        int data;
        Node left;
        Node right;
     }
*/
    int getMin(Node root) {
            if (root.left == null) {
            return root.data;
            } else {
            return getMin(root.left);
            }
            }
            int getMax(Node root) {
            if (root.right == null) {
            return root.data;
            } else {
            return getMax(root.right);
            }
            }
            boolean checkBST(Node root) {
            if (root == null) {
            return true;
            }
            Node left;
            Node right;
            if (root.left == null) {
            left = new Node();
            left.data = Integer.MIN_VALUE;
            } else {
            left = root.left;
            }
            if (root.right == null) {
            right = new Node();
            right.data = Integer.MAX_VALUE;
            } else {
            right = root.right;
            }
            if (!(root.data > getMax(left) && root.data < getMin(right))) {
        return false;
        } else {
        return checkBST(root.left) && checkBST(root.right);
        }
        }