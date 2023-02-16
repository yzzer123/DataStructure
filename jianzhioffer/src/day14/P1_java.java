package day14;

class MovingAverage {

    private int sum;
    private int p1, p2;
    private int[] q;
    private int len = 0;
    private int size;

    /**
     * Initialize your data structure here.
     */
    public MovingAverage(int size) {
        this.size = size;
        this.sum = 0;
        q = new int[size + 2];
        p1 = 0;
        p2 = 0;
    }

    public double next(int val) {
        sum += val;
        if (len == size) {
            sum -= q[p1];
            p1 = (p1 + 1) % size;
        } else {
            len++;
        }
        q[p2] = val;
        p2 = (p2 + 1) % size;
        return (sum * 1.) / len;
    }
}
