package 대회;

import java.io.*;
import java.util.StringTokenizer;

public class 순조부 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[] input, numbers;
    static int N, R;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        input = new int[N];
        numbers = new int[R];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        bw.write("순열" + "\n");
        perm(0, 0);
        bw.write("조합" + "\n");
        combi(0, 0);
        bw.write("부분집합" + "\n");
        subSet();

        bw.close();
    }

    static void perm(int depth, int flag) throws IOException {
        if (depth == R) {
            for (int i = 0; i < R; i++) {
                bw.write(numbers[i] + " ");
            }
            bw.write("\n" + "");
            return;
        }

        for (int i = 0; i < N; i++) {
            if ((flag & 1 << i) != 0) continue;
            numbers[depth] = input[i];
            perm(depth + 1, flag | 1 << i);
        }
    }

    static void combi(int depth, int flag) throws IOException {
        if (depth == R) {
            for (int i = 0; i < R; i++) {
                bw.write(numbers[i] + " ");
            }
            bw.write("\n" + "");
            return;
        }

        for (int i = 0; i < N; i++) {
            if ((flag & 1 << i) != 0) continue;
            numbers[depth] = input[i];
            combi(depth + 1, flag | 1 << i);
        }
    }

    static void subSet() throws IOException {
        for (int i = 0; i < (1 << N); i++) {
            for (int j = 0; j < N; j++) {
                if ((i & 1 << j) != 0) {
                    bw.write(input[j] + " ");
                }
            }
            bw.write("\n" + "");
        }
    }
}
