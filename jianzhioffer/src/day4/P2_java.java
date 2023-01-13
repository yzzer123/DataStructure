package day4;

import java.util.HashMap;

public class P2_java {
    public int findMaxLength(int[] nums) {  // 自己写Hash 超过99%
        int preSum = 0, maxLen = 0;
        // Hash表
        int[] map = new int[nums.length * 2 + 2];
        map[nums.length] = -1;


        nums[0] = (nums[0] == 0 ? -1 : 1);
        preSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            preSum += (nums[i] == 0 ? -1 : 1);

            if (map[preSum + nums.length] != 0 || (preSum == nums[0])) {

                maxLen = Math.max(maxLen, i - map[preSum + nums.length]);
            } else {
                map[preSum + nums.length] = i;
            }
        }

        return maxLen;
    }

    public int findMaxLength2(int[] nums) { // 用HashMap.速度慢
        int preSum = 0, maxLen = 0;
        // Hash表 不初始化容量，速度慢
//        HashMap<Integer, Integer>  map = new HashMap<>();


        // 提前申请HashMap容量大学可以加速
        HashMap<Integer, Integer> map = new HashMap<>(2 * nums.length + 1);

        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            preSum += (nums[i] == 0 ? -1 : 1);

            if (map.containsKey(preSum)) {

                maxLen = Math.max(maxLen, i - map.get(preSum));
            } else {
                map.put(preSum, i);
            }
        }

        return maxLen;
    }
}
