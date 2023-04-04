import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1701_Cubeditor {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        char[] pattern = in.readLine().toCharArray();

        int pLength = pattern.length;

        int[] pi = new int[pLength];
        for (int i = 1, j = 0; i < pLength; i++) {
            while (j > 0 && pattern[i] != pattern[j]) j = pi[j - 1];

            if (pattern[i] == pattern[j]) pi[i] = ++j;
            else pi[i] = 0;
        }

        int result = 0;
        for (int i : pi) {
            result = Math.max(i, result);
        }

        System.out.println(result);
    }
}