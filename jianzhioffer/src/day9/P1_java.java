package day9;

public class P1_java {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode slow = head, fast = head;
        while (true) {


            if (fast.next == null || fast.next.next == null) {
                break;
            }

            fast = fast.next.next;
            slow = slow.next;

        }

        ListNode p = slow.next, tmp, reverseHead = null;
        while (p != null) {
            tmp = p.next;
            p.next = reverseHead;
            reverseHead = p;
            p = tmp;
        }

        p = reverseHead;
        tmp = head;
        while (p != null) {
            if (p.val != tmp.val) {
                return false;
            }
            p = p.next;
            tmp = tmp.next;
        }
        return true;
    }
}
