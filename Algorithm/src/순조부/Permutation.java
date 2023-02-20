package 순조부;

import java.io.*;
import java.util.StringTokenizer;

public class Permutation {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int input[];
    static int numbers[];
    static boolean visited[];
    static int N, M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        input = new int[N];
        numbers = new int[M];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            input[i] = i + 1;
        }
//        perm1(0, 0);
        perm2(0, 0);
//        perm(0, 0);
//        perm3(0, 0);
        bw.close();
    }

    static void perm1(int depth, int flag) throws IOException {
        if (depth == M) {
            for (int number : numbers) {
                bw.write(number + " ");
            }
            bw.write("\n" + "");
            return;
        }
        for (int i = 0; i < N; i++) {
            if ((flag & (1 << i)) != 0) continue;
            numbers[depth] = input[i];
            perm1(depth + 1, flag | 1 << i);
        }
    }

    static void perm(int depth, int flag) throws IOException {
        if (depth == M) {
            for (int number : numbers) {
                bw.write(number + " ");
            }
            bw.write("\n" + "");
            return;
        }
        for (int i = 0; i < N; i++) {
            if ((flag & (1 << i)) != 0) continue;
            numbers[depth] = input[i];
            perm(depth + 1, flag | 1 << i);
        }
    }

    static void perm2(int depth, int flag) throws IOException {
        if (depth == M) {
            for (int number : numbers) {
                bw.write(number + " ");
            }
            bw.write("\n" + "");
            return;
        }

        for (int i = 0; i < N; i++) {
            if ((flag & 1 << i) != 0) continue;
            numbers[depth] = i + 1;
            perm2(depth + 1, flag | 1 << i);
        }
    }

    static void perm3(int depth, int flag) throws IOException {

    }
}
