import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_4354_문자열_제곱 {

    private static int[] pi;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        char[] text = in.readLine().toCharArray();
        char[] pattern = in.readLine().toCharArray();

        int tLength = text.length, pLength = pattern.length;

        pi = createTable(pattern);
    }

    static int[] createTable(char[] pattern) {
        int pLength = pattern.length;

        int[] pi = new int[pLength];
        for (int i = 1, j = 0; i < pLength; i++) {
            while (j > 0 && pattern[i] != pattern[j]) j = pi[j - 1];

            if (pattern[i] == pattern[j]) pi[i] = ++j;
            else pi[i] = 0;
        }
        return pi;
    }

    static int KMP(char[] text, char[] pattern) {
        int tLength = text.length;
        int pLength = pattern.length;
        int cnt = 0;
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0, j = 0; i < tLength; ++i) {
            while (j > 0 && text[i] != pattern[j]) j = pi[j - 1];

            if (text[i] == pattern[j]) {
                if (j == pLength - 1) {
                    cnt++;
                    list.add(i - pLength + 2);
                    j = pi[j];
                } else {
                    j++;
                }
            }
        }

        return cnt;
    }
}