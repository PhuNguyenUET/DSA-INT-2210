public class ReverseDoublyLinkedList {
    public static DoublyLinkedListNode reverse(DoublyLinkedListNode llist) {
        // Write your code here
        if (llist == null || llist.next == null) {
            return llist;
        }
        DoublyLinkedListNode cur = llist;
        DoublyLinkedListNode nxt = llist.next;
        while (nxt != null) {
            DoublyLinkedListNode tmp = cur.prev;
            cur.prev = cur.next;
            cur.next = tmp;
            cur = nxt;
            nxt = nxt.next;
        }
        DoublyLinkedListNode tmp = cur.prev;
        cur.prev = cur.next;
        cur.next = tmp;
        return cur;
    }
}
