public class PrintInReverse {
    public static void reversePrint(SinglyLinkedListNode llist) {
        // Write your code here
        if (llist == null) {
            return;
        } else {
            reversePrint(llist.next);
            System.out.println(llist.data);
        }
    }
}
