package day3;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P1_java {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4};
        System.out.println(new P1_java().threeSum(nums));
    }

    public List<List<Integer>> threeSum(int[] nums) { // 时间复杂度 o(n^2) 太慢了

        List<List<Integer>> ansList = new ArrayList<>();

        if (nums.length < 3) {
            return ansList;
        }

        // 对数组进行排序
        Arrays.sort(nums);

        int[] bloomFilter = new int[6800];
        // 对每个数字建立 hash映射
        bloomFilter[(nums[0] + 100000) / 30] |= (1 << ((nums[0] + 100000) % 30));
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {  // 对于重复的数字避免多余的计算，这样可以避免过多的除法
                bloomFilter[(nums[i] + 100000) / 30] |= (1 << ((nums[i] + 100000) % 30));
            }
        }

        // 建立双指针 来计算
        int p1 = 0, p2 = nums.length - 1, bound = nums.length - 1;
        while (p2 > p1) {
//            System.out.printf("p1=%d, p2=%d, bound=%d\n", p1, p2, bound);
//            System.out.println(Arrays.toString(nums));

            int target = -nums[p1] - nums[p2];
            boolean isFind = false;

            // 这个数在两个指针的范围内
            if (target > nums[p1] && target < nums[p2]) {
                isFind = (bloomFilter[(target + 100000) / 30] & (1 << ((target + 100000) % 30))) != 0;

            } else if ((target == nums[p1] && nums[p1 + 1] == nums[p1])
                    || (target == nums[p2] && nums[p2 - 1] == nums[p2])) {
                if ((nums[p1] != nums[p2]) || (nums[p1] == nums[p2] && p2 - p1 > 1)) { // 如果两个数相同，那么至少需要存在三个数字
                    isFind = true;
                }
            }


            if (isFind) {
                List<Integer> newTuple = new ArrayList<>(3);
                newTuple.add(nums[p1]);
                newTuple.add(target);
                newTuple.add(nums[p2]);
                ansList.add(newTuple);
//                System.out.println(newTuple);

                // 移动指针
                p2--;
                while (p2 > p1 && nums[p2] == nums[p2 + 1]) {
                    p2--;
                }
            } else if (target <= nums[p1]) {
                // 移动指针
                p2--;
                while (p2 > p1 && nums[p2] == nums[p2 + 1]) {
                    p2--;
                }
            } else {
                p1++;
                while (p1 < p2 && nums[p1 - 1] == nums[p1]) {
                    p1++;
                }
                p2 = bound;
            }


        }
        return ansList;
    }
}
