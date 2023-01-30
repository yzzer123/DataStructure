package day11;

import java.util.*;

public class P1_java {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hashTable = new HashMap<>();
        char[] encode = new char[52];
        char zero = (char) 0;
        for (int i = 0; i < strs.length; i++) {
            Arrays.fill(encode, zero);
            int len = strs[i].length();
            for (int j = 0; j < len; j++) {
                int x = strs[i].charAt(j) - 'a';
                if (encode[x] == 128) {
                    encode[x] = 0;
                    encode[26 + x]++;
                } else {
                    encode[x]++;
                }
            }
            String key = new String(encode);
            List<String> strSet = hashTable.get(key);
            if (strSet == null) {
                strSet = new ArrayList<>();
                hashTable.put(key, strSet);

            }
            strSet.add(strs[i]);

        }
        return new ArrayList<>(hashTable.values());
    }
}
