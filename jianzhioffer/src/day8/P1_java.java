package day8;

public class P1_java {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null, now = head, tmp;
        while (now != null) {
            tmp = now.next;
            now.next = pre;
            pre = now;
            now = tmp;
        }
        return pre;
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
