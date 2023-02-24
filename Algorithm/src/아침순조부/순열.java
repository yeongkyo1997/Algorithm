package 아침순조부;

import java.io.*;
import java.util.StringTokenizer;

public class 순열 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    private static int[] result;
    private static int N;
    private static int R;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        result = new int[R];
        perm(arr, 0, 0);
        bw.close();
    }

    static void perm(int[] arr, int depth, int flag) throws IOException {
        if (depth == R) {
            for (int i : result) {
                bw.write(i + " ");
            }
            bw.write("\n" + "");
            return;
        }

        for (int i = 0; i < N; i++) {
            if ((flag & 1 << i) != 0) continue;
            result[depth] = arr[i];
            perm(arr, depth + 1, flag | 1 << i);
        }
    }
}
