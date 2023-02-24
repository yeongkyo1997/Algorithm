import java.io.*;
import java.util.StringTokenizer;

public class Main_24736 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int[] score = new int[2];
        int[] info = new int[5];

        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                info[j] = Integer.parseInt(st.nextToken());
            }
            bw.write((info[0] * 6 + info[1] * 3 + info[2] * 2 + info[3] + info[4] * 2) + " ");
        }
        bw.close();
    }
}
