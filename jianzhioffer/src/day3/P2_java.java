package day3;

public class P2_java {


    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int target = 7;
        System.out.println(new P2_java().minSubArrayLen3(target, nums));
    }

    public int minSubArrayLen(int target, int[] nums) {

        if (nums.length == 0) {
            return 0;
        }


        int[] sums = new int[nums.length + 1];
        sums[0] = 0;
        sums[1] = nums[0];
        for (int i = 2; i < nums.length + 1; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }

        int p1 = 0, minLength = nums.length + 2, p2 = 1;

        while (p2 < nums.length + 1) {

            if ((sums[p2] - sums[p1]) >= target) {
                minLength = Math.min(minLength, p2 - p1);
                p1++;
                if (p1 == p2) {
                    p2++;
                }
            } else {
                p2++;
            }
        }
        return minLength == nums.length + 2 ? 0 : minLength;
    }

    public int minSubArrayLen2(int target, int[] nums) {

        if (nums.length == 0) {
            return 0;
        }


        int p1 = 0, minLength = nums.length + 2, p2 = 0, now = 0, len;

        while (p2 < nums.length) {
            now += nums[p2];
            while (target <= now && p1 <= p2) {
                len = p2 - p1 + 1;
                minLength = minLength > len ? len : minLength;
                now -= nums[p1];
                p1++;
            }
            p2++;
        }
        return minLength == nums.length + 2 ? 0 : minLength;
    }

    public int binaryFind(int[] arr, int l, int r, int target) {
        int mid;
        while (l < r) {
            mid = (l + r) >> 1;
            if (target > arr[mid]) {
                l = mid + 1;
            } else if (target < arr[mid]) {
                r = mid;
            } else {
                return mid;
            }
        }
        return arr[r] >= target ? l : -1;
    }

    public int minSubArrayLen3(int target, int[] nums) {

        if (nums.length == 0) {
            return 0;
        }
        int[] sums = new int[nums.length + 1];
        sums[0] = 0;
        sums[1] = nums[0];
        for (int i = 2; i < nums.length + 1; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }

        int minLength = nums.length + 2, p2 = 1;
        while (p2 < nums.length + 1) {
            int tag = sums[p2 - 1] + target;
            int index = binaryFind(sums, p2, sums.length - 1, tag);
//            System.out.printf("%d,%d\n", p2, index);
            if (index >= 0) {
                minLength = Math.min(index - p2 + 1, minLength);
            }
            p2++;
        }
        return minLength == nums.length + 2 ? 0 : minLength;
    }
}
