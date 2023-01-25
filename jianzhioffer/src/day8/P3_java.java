package day8;

public class P3_java {
    public void reorderList(ListNode head) {
        int size = 0;

        // 统计大小
        for (ListNode p = head; p != null; p = p.next, size++) ;

        // 偏移指针到中心点
        int mid = (size + 1) / 2;

        ListNode p2 = head;
        for (int i = 1; i <= mid; i++, p2 = p2.next) ;

        ListNode reversed = new ListNode(-1, null), tmp;
        while (p2 != null) {
            tmp = p2.next;
            p2.next = reversed.next;
            reversed.next = p2;
            p2 = tmp;
        }

        p2 = reversed.next;
        ListNode p = head, pre = head;
        while (p2 != null) {
            // 将p2追加到p后面
            tmp = p.next;
            p.next = p2;
            p = tmp;

            // p追加到p2后面
            tmp = p2.next;
            p2.next = p;
            pre = p2;
            p2 = tmp;
        }


        if (size % 2 != 0) {
            pre.next = p;
            p.next = null;
        } else {
            pre.next = null;
        }
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
