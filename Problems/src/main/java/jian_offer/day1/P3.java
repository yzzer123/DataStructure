package jian_offer.day1;

public class P3 {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];

        result[0] = 0;

        // 以 9 (1001)为例， 可以通过与8(1000)进行异或运算，得到除第一位以外剩下的二进制数(001), 001的1的个数已经在result[001]中计算过了
        // 所以 result[9] = result[(9 ^ 8)] + 1

        for (int tmp = 1, i = 1; i <= n; tmp <<= 1) {
            int bound = tmp << 1;
            for (; i < bound && i <= n; i++) {
                result[i] = 1 + result[i ^ tmp];
            }
        }
        return result;
    }
}
