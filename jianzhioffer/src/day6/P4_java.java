package day6;

public class P4_java {
    public int countSubstrings(String s) {// 枚举中心点，复杂度O(n^2)，速度85%

        int cnt = 0;
        int sLen = s.length();
        // 枚举中心点
        for (int mid = 0; mid < sLen; mid++) {
            cnt++;
            // 奇数长度回文
            for (int range = 1; mid - range >= 0 && mid + range < sLen; range++, cnt++) {
                if (s.charAt(mid - range) != s.charAt(mid + range)) {
                    break;
                }
            }

            // 偶数长度回文
            for (int range = 1; mid - range + 1 >= 0 && mid + range < sLen; range++, cnt++) {
                if (s.charAt(mid - range + 1) != s.charAt(mid + range)) {
                    break;
                }
            }
        }
        return cnt;
    }

    public int countSubstrings2(String s) { // DP解法，用bool数组判断i～j的区间是否为回文 打败30%
        int sLen = s.length();
        boolean[][] isPalingdrom = new boolean[sLen][sLen];

        int cnt = sLen;
        for (int i = 0; i < sLen; i++) {
            isPalingdrom[i][i] = true;
        }
        for (int i = sLen - 1; i >= 0; i--) {
            for (int j = i + 1; j < sLen; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i + 1 >= 3) {
                        isPalingdrom[i][j] = isPalingdrom[i + 1][j - 1];
                    } else {
                        isPalingdrom[i][j] = true;
                    }
                }
                if (isPalingdrom[i][j]) cnt++;
            }
        }
        return cnt;
    }

    public int countSubstrings3(String s) { // Manacher 算法
        int cnt = 0, sLen = s.length();
        StringBuilder buffer = new StringBuilder("$#");
        // 处理字符串
        for (int i = 0; i < sLen; i++) {
            buffer.append(s.charAt(i));
            buffer.append('#');
        }
        String t = buffer.append("!").toString();


        int tLen = t.length() - 1, rm = 0, im = 0;
        int[] f = new int[tLen + 1];
        for (int i = 1; i < tLen; i++) {
            // 初始化
            f[i] = i <= rm ? Math.min(2 * im - i, rm - i + 1) : 1;

            // 扩展中心点
            while (s.charAt(i - f[i]) == s.charAt(i + f[i])) {
                f[i]++;
            }

            if (i + f[i] - 1 > rm) {
                rm = i + f[i] - 1;
                im = i;
            }
            cnt += f[i] / 2;
        }

        return cnt;


    }


}
