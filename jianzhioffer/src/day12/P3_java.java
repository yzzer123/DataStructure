package day12;

import java.util.ArrayDeque;
import java.util.Deque;

public class P3_java {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] ans = new int[len];
        Deque<Integer> stack = new ArrayDeque<>(len); // 用Array更快，LinkedList速度慢

        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                Integer index = stack.pop();
                ans[index] = i - index;

            }
            stack.push(i);
        }
        return ans;
    }
}
