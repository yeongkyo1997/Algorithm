import java.io.*;
import java.util.StringTokenizer;

public class Main_1305_광고 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        char[] pattern = br.readLine().toCharArray();

        int pLength = pattern.length;

        int[] pi = new int[pLength];

        for (int i = 1, j = 0; i < pLength; i++) {
            while (j > 0 && pattern[i] != pattern[j]) j = pi[j - 1];

            if (pattern[i] == pattern[j]) pi[i] = ++j;
            else pi[i] = 0;
        }

        bw.write(String.valueOf(n - pi[pLength - 1]));
        bw.close();
    }
}