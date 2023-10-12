public class MergeLinkedList {
    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode dummyHead = new SinglyLinkedListNode(0);
        SinglyLinkedListNode res = dummyHead;
        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                dummyHead.next = head1;
                dummyHead = dummyHead.next;
                head1 = head1.next;
            } else {
                dummyHead.next = head2;
                dummyHead = dummyHead.next;
                head2 = head2.next;
            }
        }
        if (head1 == null) {
            dummyHead.next = head2;
        } else {
            dummyHead.next = head1;
        }
        return res.next;
    }
}
