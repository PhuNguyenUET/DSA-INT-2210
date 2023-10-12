public class ReverseLinkedList {
    public static SinglyLinkedListNode reverse(SinglyLinkedListNode llist) {
        // Write your code here
        if (llist == null || llist.next == null) {
            return llist;
        } else {
            SinglyLinkedListNode prev = null;
            SinglyLinkedListNode cur = llist;
            SinglyLinkedListNode nxt = llist.next;
            while (nxt != null) {
                cur.next = prev;
                prev = cur;
                cur = nxt;
                nxt = nxt.next;
            }
            cur.next = prev;
            return cur;
        }
    }
}
