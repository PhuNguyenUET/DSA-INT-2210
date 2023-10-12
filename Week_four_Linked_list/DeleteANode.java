public class DeleteANode {
    public static SinglyLinkedListNode deleteNode(SinglyLinkedListNode llist, int position) {
        // Write your code here
        if (position == 0) {
            return llist.next;
        } else {
            SinglyLinkedListNode prev = llist;
            for (int i = 0; i < position - 1; i++) {
                prev = prev.next;
            }
            prev.next = prev.next.next;
            return llist;
        }
    }
}
