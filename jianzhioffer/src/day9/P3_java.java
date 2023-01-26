package day9;

public class P3_java {
    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        Node newHead = new Node();
        Node pre = newHead;

        Stack stack = new Stack();
        stack.push(head);
        while (!stack.isEmpty()) {
            Node top = stack.pop();

            if (top.next != null) {
                stack.push(top.next);
            }

            if (top.child != null) {
                stack.push(top.child);
            }

            top.next = pre.next;
            top.prev = pre;
            top.child = null;
            pre.next = top;
            pre = top;
        }
        newHead.next.prev = null;

        return newHead.next;
    }

    ;

    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    static class Stack {
        StackNode top;

        public Stack() {
            top = null;
        }

        public void push(Node node) {
            top = new StackNode(node, top);
        }

        public Node pop() {
            Node popNode = top.val;
            top = top == null ? top : top.next;
            return popNode;
        }

        public boolean isEmpty() {
            return top == null;
        }
    }

    static class StackNode {
        public Node val;
        public StackNode next;

        public StackNode(Node val, StackNode next) {
            this.next = next;
            this.val = val;
        }
    }
}
