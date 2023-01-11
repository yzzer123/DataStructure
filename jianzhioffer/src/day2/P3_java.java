package day2;

public class P3_java {
    public int[] twoSum(int[] numbers, int target) {
        int p1 = 0, p2 = numbers.length - 1;

        int sum = numbers[p1] + numbers[p2];
        while (sum != target) {
            if (sum > target) {
                p2--;
            } else {
                p1++;
            }
            sum = numbers[p1] + numbers[p2];
        }
        return new int[]{p1, p2};
    }

    public int[] twoSum2(int[] numbers, int target) {
        // 建立hash表
        short[] hash = new short[2020];
        for (int i = 0; i < numbers.length; i++) {
            if (hash[numbers[i] + 1000] == 0) {
                hash[numbers[i] + 1000] = (short) (i + 1);
            }
        }
        for (int i = numbers.length - 1; i >= 0; i--) {
            if (hash[target - numbers[i] + 1000] != 0) {
                return new int[]{hash[target - numbers[i] + 1000] - 1, i};
            }
        }
        return new int[]{0, 0};
    }
}
