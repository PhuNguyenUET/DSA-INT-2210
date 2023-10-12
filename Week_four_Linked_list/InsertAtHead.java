public class InsertAtHead {
    static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode llist, int data) {
        SinglyLinkedListNode newListNode = new SinglyLinkedListNode(data);
        newListNode.next = llist;
        return newListNode;
    }
}
