package day14;

class RecentCounter {
    int head = 0;
    int tail = 0;
    int size = 0;
    int[] queue;

    public RecentCounter() {
        queue = new int[3010];
    }

    public int ping(int t) {
        queue[tail] = t;
        tail = tail + 1 > 3001 ? 0 : tail + 1;
        size++;
        int target = t - 3000;
        while (size != 0 && queue[head] < target) {
            head = head + 1 > 3001 ? 0 : head + 1;
            size--;
        }
        return size;
    }
}