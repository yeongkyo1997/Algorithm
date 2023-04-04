import java.io.*;
import java.util.StringTokenizer;

public class Main_1786_찾기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        char[] text = br.readLine().toCharArray();
        char[] pattern = br.readLine().toCharArray();
        int[] pi;
    }

    static int[] getTable(char[] pattern) {
        int pLength = pattern.length;
        int[] pi = new int[pLength];

        /*
         * i : 접미사 포인터
         * j : 접두사 포인터
         */
        for (int i = 1, j = 0; i < pLength; i++) {
            // 일치하지 않으면 j를 pi[j-1]로 이동
            // 이유 : pi[j-1]은 j-1까지의 문자열에서의 접두사와 접미사의 최대 길이
            // 따라서 j-1까지 일치했으므로 j-1까지의 문자열에서의 접두사와 접미사의 최대 길이만큼은
            // 일치한다는 것이므로 pi[j-1]만큼 이동
            while (j > 0 && pattern[i] != pattern[j]) j = pi[j - 1];

            if (pattern[i] == pattern[j]) pi[i] = ++j;
        }
        return pi;
    }
}