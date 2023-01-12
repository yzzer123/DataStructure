package day3;

public class P3_java {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int mul, cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            mul = 1;
            for (int j = i; j < nums.length; j++) {
                mul *= nums[j];
                if (mul < k) {
                    cnt++;
                } else {
                    break;
                }
            }
        }
        return cnt;
    }

    public int numSubarrayProductLessThanK2(int[] nums, int k) {  // O(n)
        if (k == 0) {
            return 0;
        }

        int mul = 1, cnt = 0;
        int p1 = 0, p2 = 0;
        while (p2 < nums.length) {
            // 一直向后累乘，统计子数组个数
            mul *= nums[p2];
            p2++;

            if (mul < k) {
                cnt += (p2 - p1);
            } else {
                // 累乘结果超出k后，移动第一个指针来缩小区间
                while (p1 < p2 && mul >= k) {
                    mul /= nums[p1];
                    p1++;
                }
                cnt += (p2 - p1);
            }
        }
        return cnt;
    }

    public int numSubarrayProductLessThanK3(int[] nums, int k) {
        if (k == 0) {
            return 0;
        }

        double[] logMpl = new double[nums.length + 1];
        logMpl[0] = 0.;
        for (int i = 1; i < logMpl.length; i++) {
            logMpl[i] = logMpl[i - 1] + Math.log(nums[i - 1]);
        }
        int cnt = 0;
        double logk = Math.log(k);
        for (int i = 0; i < nums.length; i++) {
            // 对于每个区间开头，二分搜索区间尽头
            double target = logMpl[i] + logk;
            int l = i + 1, r = logMpl.length - 1, mid;
            int index = -1;
            while (l < r) {
                mid = (l + r + 1) >> 1;
                if (logMpl[mid] < target) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            if (l >= r)
                index = logMpl[l] < target ? l : -1;

            if (index != -1) {
                cnt += (index - i);
            }
        }

        return cnt;
    }

}
