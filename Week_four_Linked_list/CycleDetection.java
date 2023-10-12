public class CycleDetection {
    static boolean hasCycle(SinglyLinkedListNode head) {
        SinglyLinkedListNode turtle = head;
        SinglyLinkedListNode rabbit = head;
        while (turtle != null && rabbit != null && rabbit.next != null) {
            turtle = turtle.next;
            rabbit = rabbit.next.next;
            if (turtle == rabbit) {
                return true;
            }
        }
        return false;
    }
}
