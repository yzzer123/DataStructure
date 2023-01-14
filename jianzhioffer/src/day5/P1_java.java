package day5;

public class P1_java {

    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }

        short[] preSum1 = new short[26];  // 记录s1的各字母数量
        short[] preSum2 = new short[26];  // 记录当前子串的各字母数量
        short cnt = 0; //当前符合统计数量

        int len1 = s1.length(), len2 = s2.length();
        // 对s1进行统计
        for (int i = 0; i < len1; i++) {
            preSum1[s1.charAt(i) - 'a']++;
            preSum2[s2.charAt(i) - 'a']++;

        }

        for (int i = 0; i < 26; i++) {
            if (preSum1[i] == preSum2[i]) {
                cnt++;
            }
        }

        if (cnt == 26) {
            return true;
        }

        // 对进行遍历统计
        for (int i = len1, tmp; i < len2; i++) {


            tmp = s2.charAt(i) - 'a';
            preSum2[tmp]++;
            if (preSum2[tmp] - 1 == preSum1[tmp]) {
                cnt--;
            } else if (preSum2[tmp] == preSum1[tmp]) {
                cnt++;
            }


            tmp = s2.charAt(i - len1) - 'a';
            preSum2[tmp]--;
            if (preSum2[tmp] + 1 == preSum1[tmp]) {
                cnt--;
            } else if (preSum2[tmp] == preSum1[tmp]) {
                cnt++;
            }

            if (cnt == 26) {
                return true;
            }

        }

        return false;

    }

    public boolean checkInclusion2(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) {
            return false;
        }

        short[] cnt = new short[26];

        for (int i = 0; i < len1; i++) {
            cnt[s1.charAt(i) - 'a']--;
        }


        for (int i = 0, left = 0; i < len2; i++) {
            int index = s2.charAt(i) - 'a';
            cnt[index]++;

            while (cnt[index] > 0) {
                cnt[s2.charAt(left) - 'a']--;
                left++;
            }

            if (i - left + 1 == len1) {
                return true;
            }
        }

        return false;
    }
}
