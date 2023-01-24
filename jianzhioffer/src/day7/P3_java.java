package day7;

public class P3_java {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int times = 0;
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA.next;
            pB = pB.next;

            if (pA == null) {
                if (times < 2) {
                    times++;
                    pA = headB;
                } else {
                    return null;
                }
            }

            if (pB == null) {
                if (times < 2) {
                    times++;
                    pB = headA;
                } else {
                    return null;
                }
            }
        }
        return pA;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
