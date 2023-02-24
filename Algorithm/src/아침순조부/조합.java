package 아침순조부;

import java.io.*;
import java.util.StringTokenizer;

public class 조합 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    private static int N;
    private static int R;
    private static int[] result;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        int[] list = new int[N];
        result = new int[R];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        combi(list, 0, 0, 0);
        bw.close();
    }

    static void combi(int[] list, int depth, int idx, int flag) throws IOException {
        if (depth == R) {
            for (int i : result) {
                bw.write(i + " ");
            }
            bw.write("\n" + "");
            return;
        }

        for (int i = idx; i < N; i++) {
            if ((flag & 1 << i) != 0) continue;

            result[depth] = list[i];
            combi(list, depth + 1, i, flag | 1 << i);
        }
    }
}
