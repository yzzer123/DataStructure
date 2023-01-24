package day7;

public class P2_java {

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head, slow = head;

        // 2 * (a + b) = a + n * (b + c) + b
        // a = (n - 1) * b + n * c
        // 慢指针再走 n 圈 - b 后正好 步长和 a 相等，等效于，一个指针从头部同时出发和slow相遇
        do {
            if (slow.next == null) {
                return null;
            }
            slow = slow.next;

            if (fast.next == null || fast.next.next == null) {
                return null;
            }

            fast = fast.next.next;
        } while (fast != slow);

        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
