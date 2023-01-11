package day1;

public class P1_java {

    public long abs(int n) {
        if (n == -2147483648) {
            return 2147483648L;
        }
        return n > 0 ? n : -n;
    }


    public int divide(int a, int b) {
        int signed = 1;

        // 对特殊情况打表，以提高效率
        if ((a > 0 && b < 0) || (a < 0 && b > 0)) {
            signed = -1;
        } else if (a == 0) {
            return 0;
        } else if (b == 0) {
            return 0x7fffffff;
        }

        if (b == 1) {
            return a;
        } else if (b == -1) { // 除0以外， 唯一的溢出情况
            if (a == 0x80000000) {
                return 0x7fffffff;
            }
            return -a;
        }

        long remain = abs(a), divider = abs(b);

        long[] exp_table = new long[32];
        int res_index = 0;

        // 打表 2^i * divider
        long exp_divider = divider;
        int i = 0;
        while (remain >= exp_divider) {
            exp_table[i++] = exp_divider;
            exp_divider <<= 1;
        }

        if (i == 0) {
            return 0;
        }

        // 索引回退一个
        i--;
        int res = 0;
        for (; i >= 0; i--) {
            res <<= 1;
            if (remain >= exp_table[i]) {
                res += 1;
                remain -= exp_table[i];
            }
        }

        return signed > 0 ? res : -res;
    }
}