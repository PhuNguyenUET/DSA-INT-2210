public class InsertAtAPosition {
    public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode llist, int data, int position) {
        // Write your code here
        SinglyLinkedListNode newListNode = new SinglyLinkedListNode(data);
        if (llist == null) {
            return newListNode;
        } else {
            SinglyLinkedListNode tmp = llist;
            for (int i = 0; i < position - 1; i++) {
                tmp = tmp.next;
            }
            SinglyLinkedListNode nxt = tmp.next;
            tmp.next = newListNode;
            newListNode.next = nxt;
            return llist;
        }
    }
}
