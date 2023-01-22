package day6;

public class P2_java {
    public int code(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        } else if (c >= 'a' && c <= 'z') {
            return c - 'a' + 10;
        } else if (c >= 'A' && c <= 'Z') {
            return c - 'A' + 10;
        }
        return -1;
    }


    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            int x = code(s.charAt(i));
            while (x == -1 && i < j) {
                i++;
                x = code(s.charAt(i));
            }
            if (x == -1) {
                break;
            }
            int y = code(s.charAt(j));
            while (y == -1 && i < j) {
                j--;
                y = code(s.charAt(j));
            }
            if (y == -1) {
                break;
            }
            if (x != y) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
