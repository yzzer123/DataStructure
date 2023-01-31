package day12;

import java.util.Arrays;

public class P2_java {
    public int[] asteroidCollision(int[] asteroids) {
        int[] stack = new int[asteroids.length + 1];
        int index = 0;
        stack[index++] = -1;
        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] < 0) {
                int v = -asteroids[i];
                while (stack[index - 1] > 0 && stack[index - 1] < v) {
                    index--;
                }
                if (stack[index - 1] < 0) {
                    stack[index++] = -v;
                } else if (stack[index - 1] == v) {
                    index--;
                }
            } else {
                stack[index++] = asteroids[i];
            }
        }


        return Arrays.copyOfRange(stack, 1, index);
    }
}
