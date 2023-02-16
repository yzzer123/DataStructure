package day13;

import java.util.ArrayDeque;
import java.util.Deque;

public class P1_java {
    public int largestRectangleArea(int[] heights) {

        Deque<Integer> stack = new ArrayDeque<>(heights.length);
        int maxSize = 0;
        int v, index, left, top = 0;

        for (int i = 0; i < heights.length; i++) {
            v = heights[i];
            while (!stack.isEmpty() && heights[stack.peek()] > v) {
                index = stack.pop();
                left = stack.isEmpty() ? top : stack.peek() + 1;
                maxSize = Math.max(heights[index] * (i - left), maxSize);
                // System.out.println(left + " " + i);
            }
            if (v == 0) {
                top = i + 1;
            } else {
                stack.push(i);
            }
        }

        while (!stack.isEmpty()) {
            index = stack.pop();
            left = stack.isEmpty() ? top : stack.peek() + 1;
            maxSize = Math.max(heights[index] * (heights.length - left), maxSize);
            // System.out.println("last: " + left + " " + index);
        }
        return maxSize;
    }
}
