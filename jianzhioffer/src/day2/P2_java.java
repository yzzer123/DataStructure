package day2;

public class P2_java {
    public static void main(String[] args) {
        System.out.print("{");
        for (int i = 0; i < 26; i++) {
            System.out.print((1 << i) + ", ");
        }
        System.out.println("}");
    }

    public int maxProduct(String[] words) {
        // 对26个字母进行编码的哈希表
        int[] charTable = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072, 262144, 524288, 1048576, 2097152, 4194304, 8388608, 16777216, 33554432};
        int[] wordsEncode = new int[words.length];

        // 对单词进行编码

        for (int i = 0; i < words.length; i++) {
            wordsEncode[i] = 0;
            for (int j = 0; j < words[i].length(); j++) {
                wordsEncode[i] |= charTable[words[i].charAt(j) - 'a'];
            }
        }

        int max_ans = 0;

        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((wordsEncode[i] & wordsEncode[j]) == 0) {
                    max_ans = Math.max(words[i].length() * words[j].length(), max_ans);
                }
            }
        }

        return max_ans;
    }
}
