package day5;

import java.util.ArrayList;
import java.util.List;

public class P2_java {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();

        int len1 = p.length(), len2 = s.length();
        if (len1 > len2) {
            return res;
        }

        short[] cnt = new short[26];

        for (int i = 0; i < len1; i++) {
            cnt[p.charAt(i) - 'a']--;
        }


        for (int i = 0, left = 0; i < len2; i++) {
            int index = s.charAt(i) - 'a';
            cnt[index]++;

            while (cnt[index] > 0) {
                cnt[s.charAt(left) - 'a']--;
                left++;
            }

            if (i - left + 1 == len1) {
                res.add(left);
            }
        }
        return res;
    }
}
