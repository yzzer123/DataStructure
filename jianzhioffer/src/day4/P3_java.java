package day4;

public class P3_java {
    public int pivotIndex(int[] nums) { // 超过100%
        int totalSum = 0;

        // 计算前缀和
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }

        // 枚举中间值
        for (int i = 0, preSum = 0; i < nums.length; i++) {
            totalSum -= nums[i];

            if (preSum == totalSum) {
                return i;
            }

            preSum += nums[i];
        }
        return -1;
    }

}
