package day13;

import java.util.ArrayDeque;
import java.util.Deque;

public class P2_java {
    public int maximalRectangle(String[] matrix) {
        if (matrix.length == 0) {
            return 0;
        }

        int m = matrix.length, n = matrix[0].length();

        int[][] heights = new int[n][m];
        Deque<Integer> stack = new ArrayDeque<>(m);

        // 构造直方图数组
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i].charAt(j) != '0') {
                    heights[j][i] = (j == 0 ? 1 : heights[j - 1][i] + 1);
                }
            }
        }

        // 开始计算最大值
        int maxSize = 0;
        int size, left, v, top;
        for (int i = 0; i < n; i++) {
            int[] h = heights[i];
            top = 0;
            for (int j = 0; j < m; j++) {
                v = h[j];
                while (!stack.isEmpty() && h[stack.peek()] > v) {
                    size = h[stack.pop()];
                    left = stack.isEmpty() ? top : stack.peek() + 1;
                    maxSize = Math.max(maxSize, size * (j - left));
                }
                if (v == 0) {
                    top = j + 1;
                } else {
                    stack.push(j);
                }
            }

            while (!stack.isEmpty()) {
                size = h[stack.pop()];
                left = stack.isEmpty() ? top : stack.peek() + 1;
                maxSize = Math.max(maxSize, size * (m - left));
            }
        }


        return maxSize;
    }
}
