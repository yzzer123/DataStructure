package day2;

import java.util.Arrays;

public class P1_java {
    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 2};
        System.out.println(new P1_java().singleNumber(nums));
    }

    public int singleNumber(int[] nums) {
        int BUCKET_SIZE = 100;
        int divider = BUCKET_SIZE; // 桶排序除数

        short[] buckets = new short[BUCKET_SIZE]; // 桶计数 可以开更大的空间使得速度更快，但是整体速度还是线性的

        int number = 0; // 尾数统计
        int cnt = 0; // 元素所在桶的计数

        while (cnt != 1) {
            int min_divider = divider / BUCKET_SIZE;
            for (int i = 0; i < nums.length; i++) {
                if ((nums[i] + 2147483648L) % min_divider == number) {
//                    System.out.printf("%d, %d, %d, %d\n", (int)(((num + 2147483648L) % divider) / min_divider), num, divider, min_divider);
                    buckets[(int) (((nums[i] + 2147483648L) % divider) / min_divider)]++;

                }
            }
//            System.out.println(Arrays.toString(buckets));
            // 找到元素所在的桶
            for (int i = 0; i < 100; i++) {
                if (buckets[i] % 3 != 0) {
                    cnt = buckets[i];

                    number += (i * (divider / BUCKET_SIZE));
                    break;
                }
            }

            divider *= BUCKET_SIZE;
            Arrays.fill(buckets, (short) 0);
        }
        // 最后扫描一遍，找到这个数
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] + 2147483648L) % (divider / BUCKET_SIZE) == number) {
                return nums[i];
            }
        }
        return 0;
    }

    public int singleNumber2(int[] nums) {
        int ones = 0, twos = 0;
        for (int num : nums) {
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }

}
