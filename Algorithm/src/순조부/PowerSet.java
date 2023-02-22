package 순조부;

import java.io.*;
import java.util.StringTokenizer;

public class PowerSet {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int input[];
    static boolean visited[];
    private static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        input = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
//        subset(0);
        subset1(0);
        bw.close();
    }

//    static void generateSubSet(int cnt) throws IOException {
//        if (cnt == N) {
//            for (int i = 0; i < N; i++) {
//                if (visited[i]) continue;
//                bw.write(input[i] + " ");
//            }
//            bw.write("\n" + "");
//            return;
//        }
//        visited[cnt] = true;
//        generateSubSet(cnt + 1);
//        visited[cnt] = false;
//        generateSubSet(cnt + 1);
//    }


//    static void subset1(int cnt) throws IOException {
//        if (cnt == N) {
//            for (int i = 0; i < N; i++) {
//                if (visited[i]) continue;
//                bw.write(input[i] + " ");
//            }
//            bw.write("\n" + "");
//            return;
//        }
//
//        visited[cnt] = true;
//        subset1(cnt + 1);
//        visited[cnt] = false;
//        subset1(cnt + 1);
//    }

//    static void subset(int cnt) throws IOException {
//        for (int i = 0; i < (1 << N); i++) {
//            for (int j = 0; j < N; j++) {
//                if ((i & 1 << j) == 0) continue;
//                bw.write(input[j] + " ");
//            }
//            bw.write("\n" + "");
//        }
//    }

    static void subset(int cnt) throws IOException {
        for (int i = 0; i < (1 << N); i++) {
            for (int j = 0; j < N; j++) {
                if ((i & 1 << j) == 0) continue;
                bw.write(input[j] + " ");
            }
            bw.write("\n" + "");
        }
    }

    static void subset1(int cnt) throws IOException {
        if (cnt == N) {
            for (int i = 0; i < N; i++) {
                if (visited[i]) continue;
                bw.write(input[i] + " ");
            }
            bw.write("\n" + "");
            return;
        }

        visited[cnt] = true;
        subset1(cnt + 1);
        visited[cnt] = false;
        subset1(cnt + 1);
    }
}
