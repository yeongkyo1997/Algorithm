import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_13276_Prefix와_Suffix {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        char[] text = br.readLine().toCharArray();
        char[] prefix = br.readLine().toCharArray();
        char[] suffix = br.readLine().toCharArray();

        List<Integer> preArr = KMP(text, prefix, 0, makeTable(prefix));
        List<Integer> sufArr = KMP(text, suffix, 0, makeTable(suffix));
        System.out.println(preArr);
        System.out.println(sufArr);
        System.out.println(Arrays.toString(makeTable(prefix)));
        System.out.println(Arrays.toString(makeTable(suffix)));
    }

    static int[] makeTable(char[] pattern) {
        int pLength = pattern.length;
        int[] pi = new int[pLength];

        for (int i = 1, j = 0; i < pLength; i++) {
            while (j > 0 && pattern[j] != pattern[i]) j = pi[j - 1];

            if (pattern[i] == pattern[j]) pi[i] = ++j;
            else pi[i] = 0;
        }
        return pi;
    }

    static List<Integer> KMP(char[] text, char[] pattern, int start, int[] pi) {
        List<Integer> list = new ArrayList<>();
        int tLength = text.length, pLength = pattern.length;

        for (int i = 0, j = 0; i < tLength; i++) {
            while (j > 0 && text[i] != pattern[j]) j = pi[j - 1];

            if (text[i] == pattern[j]) {
                if (j == pLength - 1) {
                    list.add(i - pLength + 2);
                    j = pi[j];
                } else j++;
            }
        }
        return list;
    }
}