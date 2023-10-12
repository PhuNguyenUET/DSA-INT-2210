public class InsertIntoDoublyLinkedList {
    public static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode llist, int data) {
        // Write your code here
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
        if (llist == null) {
            return newNode;
        }
        DoublyLinkedListNode tmp = llist;
        DoublyLinkedListNode prev = null;
        while (tmp != null && tmp.data <= data) {
            prev = tmp;
            tmp = tmp.next;
        }
        if(prev == null) {
            newNode.next = llist;
            llist.prev = newNode;
            return newNode;
        } else {
            prev.next = newNode;
            newNode.prev = prev;
            newNode.next = tmp;
            if (tmp != null) {
                tmp.prev = newNode;
            }
            return llist;
        }
    }
}
