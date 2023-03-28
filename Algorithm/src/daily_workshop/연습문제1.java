package daily_workshop;

import java.io.*;
import java.util.StringTokenizer;

public class 연습문제1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[] blue;
    static int[] yellow;

    public static void main(String[] args) throws IOException {
        int N = 8;
        blue = new int[N + 1];
        yellow = new int[N + 1];

        blue[1] = 1;
        yellow[1] = 1;

        for (int i = 2; i <= N; i++) {
            blue[i] = blue[i - 1] + yellow[i - 1];
            yellow[i] = blue[i - 1];
        }

        bw.write((blue[N] + yellow[N]) + "");
        bw.close();
    }
}
