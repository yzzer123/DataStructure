package day10;

import java.util.Arrays;

public class P3_java {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length() || s.equals(t)) {
            return false;
        }
        char[] sCharArr = s.toCharArray(), tCharArr = t.toCharArray();
        Arrays.sort(sCharArr);
        Arrays.sort(tCharArr);
        int len = sCharArr.length;
        for (int i = 0; i < len; i++) {
            if (sCharArr[i] != tCharArr[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length() || s.equals(t)) {
            return false;
        }

        int len = s.length();
        int[] cnt = new int[128];
        char[] sC = s.toCharArray(), tC = t.toCharArray();
        for (int i = 0; i < len; i++) {
            cnt[sC[i]]++;
            cnt[tC[i]]--;

        }


        for (int i = 97; i < 123; i++) {
            if (cnt[i] != 0) return false;
        }
        return true;
    }
}
