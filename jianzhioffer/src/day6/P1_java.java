package day6;

public class P1_java {
    public String minWindow(String s, String t) {
        long strEncode = 0L;
        int[] charCount = new int[64];


        int sLen = s.length(), tLen = t.length();

        int beginIndex = -1, endIndex = -1, minLen = sLen + 1;


        // 扫描t进行统计
        int cnt = 0;
        for (int i = 0; i < tLen; i++) {
            charCount[t.charAt(i) - 'A']--;
            long code = 1L << (t.charAt(i) - 'A');
            if ((strEncode & code) == 0L) {
                strEncode |= code;
                cnt++;
            }
        }

        for (int i = 0, j = 0; i < sLen; i++) {
            int x = s.charAt(i) - 'A';
            // ;
            if ((strEncode & (1L << x)) != 0) {
                charCount[x]++;
                if (charCount[x] == 0) {
                    // System.out.println(s.charAt(i));
                    cnt--;
                    while (cnt == 0) {
                        // 满足子串条件，开始右移左指针
                        if (i - j + 1 < minLen) {
                            minLen = i - j + 1;
                            beginIndex = j;
                            endIndex = i + 1;
                        }
                        int y = s.charAt(j) - 'A';
                        if ((strEncode & (1L << y)) != 0L) {
                            charCount[y]--;
                            if (charCount[y] == -1) {
                                cnt++;
                            }
                        }
                        j++;
                    }
                }

            }

        }
        return minLen == sLen + 1 ? "" : s.substring(beginIndex, endIndex);
    }
}
