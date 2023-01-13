package day4;

import java.util.HashMap;

public class P1_java {

    public int subarraySum(int[] nums, int k) {
        // 构造存储前缀和的hashmap

        HashMap<Integer, Integer> map = new HashMap<>();

        // 第一位前缀和是0
        map.put(0, 1);

        int preSum = 0, count = 0;
        // 求前缀和，bin统计
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];

            if (map.containsKey(preSum - k)) {
                count += map.get(preSum - k);
            }

            map.put(preSum, map.getOrDefault(preSum, 0) + 1);

        }
        return count;

    }

}
