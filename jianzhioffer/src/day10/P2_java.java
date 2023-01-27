package day10;

public class P2_java {
}


class LRUCache {


    int size;
    ListNode head, tail;
    ListNode[] indexMap;

    public LRUCache(int capacity) {
        indexMap = new ListNode[10005];

        size = capacity;
        head = new ListNode(-1, -1, null);
        tail = head;
    }

    public int get(int key) {
        if (indexMap[key] == null) {
            return -1;
        }
        ListNode pre = indexMap[key];
        ListNode now = pre.next;
        if (tail != now) {
            pre.next = now.next;
            now.next = null;
            tail.next = now;
            indexMap[key] = tail;
            indexMap[pre.next.key] = pre;
            tail = tail.next;
        }
        return now.val;
    }

    public void put(int key, int value) {
        if (get(key) != -1) {
            tail.val = value;
            return;
        }
        ListNode newNode = new ListNode(key, value, null);
        tail.next = newNode;
        indexMap[key] = tail;
        tail = newNode;
        size--;
        if (size < 0) {
            head = head.next;
            indexMap[head.key] = null;
        }
    }

    static class ListNode {
        public int val;
        public int key;
        public ListNode next;

        public ListNode(int k, int v, ListNode n) {
            key = k;
            val = v;
            next = n;
        }
    }
}