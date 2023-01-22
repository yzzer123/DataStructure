package day5;

public class P3_java {
    public static void main(String[] args) {

        System.out.println(new P3_java().lengthOfLongestSubstring("hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"));
    }

    public int lengthOfLongestSubstring(String s) { // 省空间
        int m = s.length(), maxLen = 0;
        long[] strEncode = new long[3];

        for (int left = 0, right = 0; right < m; right++) {
            int x = s.charAt(right);
            int pos = x / 60;
            long code = (1L << (x % 60));
            strEncode[pos] ^= code;
            while ((strEncode[pos] & code) == 0L) {
                int y = s.charAt(left);
                strEncode[y / 60] ^= (1L << (y % 60));
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
            System.out.println(s.substring(left, right));
        }

        return maxLen;
    }

    public int lengthOfLongestSubstring2(String s) { // 省时间
        int m = s.length(), maxLen = 0;
        boolean[] strEncode = new boolean[128];

        for (int left = 0, right = 0; right < m; right++) {
            int x = s.charAt(right);
            strEncode[x] = !strEncode[x];
            while (!strEncode[x]) {
                int y = s.charAt(left);
                strEncode[y] = !strEncode[y];
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
