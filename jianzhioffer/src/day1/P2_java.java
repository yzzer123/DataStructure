package day1;

public class P2_java {

    public String addBinary(String a, String b) {
        // 交换较长的字符串位置
        if (b.length() > a.length()) {
            String c = a;
            a = b;
            b = c;
        }

        int offset = 1, count = a.length();
        char[] result = new char[count + 1];
        char[] a_chars = a.toCharArray(); // 加速
        char[] b_chars = b.toCharArray();

        int remain = 0, now = 0;
        int a_index = count - 1, b_index = b.length() - 1;
        for (; b_index >= 0; a_index--, b_index--) {
            now = remain + (a_chars[a_index] - '0') + (b_chars[b_index] - '0');
            result[a_index + 1] = (char) ('0' + now % 2);
            remain = now / 2;
        }
        for (; a_index >= 0; a_index--) {
            now = remain + (a_chars[a_index] - '0');
            result[a_index + 1] = (char) ('0' + now % 2);
            remain = now / 2;
        }
        if (remain > 0) {
            offset = 0;
            count++;
            result[0] = '1';
        }
        return new String(result, offset, count);
    }
}
