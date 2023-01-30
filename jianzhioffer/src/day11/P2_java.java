package day11;

public class P2_java {
    public boolean isAlienSorted(String[] words, String order) {
        char[] orderEncode = new char[26];
        int ordLen = order.length();
        for (short i = 0; i < ordLen; i++) {
            orderEncode[order.charAt(i) - 'a'] = (char) i;
        }
        for (int i = 0; i < words.length - 1; i++) {
            int minLen = Math.min(words[i].length(), words[i + 1].length());
            for (int j = 0; j < minLen; j++) {
                int x = words[i].charAt(j) - 'a';
                int y = words[i + 1].charAt(j) - 'a';
                if (x == y) {
                    if (j == minLen - 1 && minLen != words[i].length()) {
                        return false;
                    }
                    continue;
                } else if (orderEncode[x] < orderEncode[y]) {
                    break;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
