package day9;

public class P2_java {


    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node newNode = new Node(insertVal, null);
            newNode.next = newNode;
            return newNode;
        }

        Node pre = head, tail = head.next;
        if (pre == tail) {
            head.next = new Node(insertVal, head);
            return head;
        }

        while (true) {
            if ((pre.val <= insertVal && tail.val >= insertVal)
                    || (pre.val > tail.val && (insertVal > pre.val || insertVal < tail.val))) {
                break;
            }
            pre = tail;
            tail = tail.next;
            if (pre == head) {
                // 完成一次循环了
                break;
            }
        }

        pre.next = new Node(insertVal, tail);
        return head;
    }

    ;

    static class Node {
        public int val;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }
}
