package day8;

public class P2_java {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 头插法构造链表
        ListNode ans = new ListNode(-1, null);

        // 首先遍历，反转链表
        ListNode pre = null, now = l1, tmp;
        while (now != null) {
            tmp = now.next;
            now.next = pre;
            pre = now;
            now = tmp;
        }

        l1 = pre;

        pre = null;
        now = l2;

        while (now != null) {
            tmp = now.next;
            now.next = pre;
            pre = now;
            now = tmp;
        }

        l2 = pre;

        // 反转相加
        int adder = 0;
        while (l2 != null && l1 != null) {
            int sum = l1.val + l2.val + adder;
            ListNode newNode = new ListNode(sum % 10, ans.next);
            ans.next = newNode;
            adder = sum / 10;
            l2 = l2.next;
            l1 = l1.next;
        }

        ListNode remain = (l1 == null ? l2 : l1);
        while (remain != null) {
            int sum = remain.val + adder;
            ListNode newNode = new ListNode(sum % 10, ans.next);
            ans.next = newNode;
            adder = sum / 10;
            remain = remain.next;
        }

        if (adder != 0) {
            ListNode newNode = new ListNode(adder, ans.next);
            ans.next = newNode;
        }
        return ans.next;
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
