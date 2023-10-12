public class DeleteDuplicate {
    public static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode llist) {
        // Write your code here
        if (llist == null || llist.next == null) {
            return llist;
        }
        SinglyLinkedListNode srt = llist;
        SinglyLinkedListNode end = llist;
        while (srt != null && end != null) {
            while (end != null && srt.data == end.data) {
                end = end.next;
            }
            srt.next = end;
            srt = end;
        }
        return llist;
    }
}
