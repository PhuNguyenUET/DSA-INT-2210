public class InsertAtTail {
    static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
        SinglyLinkedListNode newListNode = new SinglyLinkedListNode(data);
        if (head == null) {
            return newListNode;
        } else {
            SinglyLinkedListNode traverse = head;
            while (traverse.next != null) {
                traverse = traverse.next;
            }
            traverse.next = newListNode;
            return head;
        }
    }
}
