package day7;


public class P1_java {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(-1, head), tail = head;

        // 先找到第n个节点
        for (int i = 1; i < n; i++) {
            tail = tail.next;
        }


        while (tail.next != null) {
            pre = pre.next;
            tail = tail.next;
        }
        if (pre.next == head) {
            head = head.next;
        } else {
            pre.next = pre.next.next;
        }


        return head;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
