import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_13506_카멜레온_부분_문자열 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N;
    static int[] fail;
    static int[] A;
    static char[] S;

    public static void main(String[] args) throws Exception {
        S = br.readLine().toCharArray();
        N = S.length;
        fail = new int[N];
        A = new int[N];

        for (int i = 1, j = 0; i < N; i++) {
            while (j > 0 && S[i] != S[j]) j = fail[j - 1];
            if (S[i] == S[j]) fail[i] = ++j;
            if (i != N - 1) A[fail[i]] = 1;
        }

        for (int i = fail[N - 1]; i > 0; i = fail[i - 1]) {
            if (A[i] == 1) {
                S[i] = 0;
                for (int j = 0; j < i; j++) {
                    bw.write(S[j]);
                }
                bw.flush();
                return;
            }
        }
        bw.write("-1");
        bw.flush();
    }
}