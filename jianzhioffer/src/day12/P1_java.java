package day12;

import java.util.ArrayDeque;
import java.util.Deque;

public class P1_java {
    public int strToInt(String str) { // 手写数字转换更快
        int num = 0;
        char[] strArr = str.toCharArray();

        for (int i = (strArr[0] == '-' ? 1 : 0); i < strArr.length; i++) {
            num = num * 10 + (strArr[i] - '0');
        }
        return strArr[0] == '-' ? -num : num;
    }

    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].length() == 1 && (tokens[i].charAt(0) < 48)) {
                int b = stack.pop(), a = stack.pop();
                switch (tokens[i].charAt(0)) {
                    case '+':
                        a += b;
                        break;
                    case '-':
                        a -= b;
                        break;
                    case '*':
                        a *= b;
                        break;
                    case '/':
                        a /= b;
                        break;
                }
                stack.push(a);
            } else {
                stack.push(strToInt(tokens[i]));
            }
        }
        return stack.peek();
    }
}
