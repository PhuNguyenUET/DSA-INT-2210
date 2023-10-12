public class GetNodeValue {
    public static int getNode(SinglyLinkedListNode llist, int positionFromTail) {
        // Write your code here
        SinglyLinkedListNode tmp = llist;
        int count = 0;
        while (tmp != null) {
            count ++;
            tmp = tmp.next;
        }
        for (int i = 0; i < count - positionFromTail - 1; i++) {
            llist = llist.next;
        }
        return llist.data;
    }
}
