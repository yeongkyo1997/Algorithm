import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M;
    static int[] arr;

    static void perm(int depth, int[] comb, int flag) throws IOException {
        if (depth == M) {
            for (int c : comb) {
                bw.write(c + " ");
            }
            bw.write("\n");
            return;
        }
        for (int i = 1; i < N + 1; i++) {
            if ((flag & (1 << i)) == 0) {
                comb[depth] = i;
                perm(depth + 1, comb, flag | (1 << i));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        perm(0, new int[M], 0);
        bw.close();
    }
}