package 순조부;

import java.io.*;
import java.util.StringTokenizer;

public class Combination {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M;
    static int[] numbers;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        numbers = new int[M];
        combi(0, 1, 0);
        combi1(0, 1);
        bw.close();
    }

//    static void combi(int depth, int start, int flag) throws IOException {
//        if (depth == M) {
//            for (int number : numbers) {
//                bw.write(number + " ");
//            }
//            bw.write("\n" + "");
//            return;
//        }
//        for (int i = start; i < N + 1; i++) {
//            if ((flag & 1 << i) != 0) continue;
//            numbers[depth] = i;
//            combi(depth + 1, i, flag | 1 << i);
//        }
//    }

    static void combi(int depth, int start, int flag) throws IOException {
        if (depth == M) {
            for (int number : numbers) {
                bw.write(number + " ");
            }
            bw.write("\n" + "");
            return;
        }

        for (int i = start; i < N + 1; i++) {
            if ((flag & 1 << i) != 0) continue;

            numbers[depth] = i;
            combi(depth + 1, i, flag | 1 << i);
        }
    }

    static void combi1(int depth, int start) throws IOException {
        if (depth == M) {
            for (int number : numbers) {
                bw.write(number + " ");
            }
            bw.write("\n" + "");
            return;
        }

        for (int i = start; i < N; i++) {
            numbers[depth] = i;
            combi1(depth + 1, i + 1);
        }
    }
}
