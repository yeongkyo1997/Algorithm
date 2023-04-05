import java.io.*;

public class Main_1401_요컨대_형택이의_사탕봉지 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            if (N == 1) {
                bw.write("1\n1\n");
            } else if (N == 2) {
                bw.write("1\n1 2\n");
            } else if (N == 3) {
                bw.write("3\n1 2\n1 3\n2 3\n");
            } else if (N == 4) {
                bw.write("2\n1 2 4\n2 3 4\n");
            } else if (N == 5) {
                bw.write("6\n1 2 4\n1 2 5\n1 3 5\n2 3 4\n2 4 5\n3 4 5\n");
            } else if (N == 6) {
                bw.write("3\n1 2 4 6\n1 3 5 6\n2 3 4 5\n");
            } else if (N == 7) {
                bw.write("6\n1 2 4 7\n1 3 5 7\n2 3 6 7\n3 4 5 6\n3 5 6 7\n4 5 6 7\n");
            } else if (N == 8) {
                bw.write("4\n1 2 4 6 8\n1 3 5 7 8\n2 3 4 5 7\n2 4 5 6 8\n");
            } else if (N == 9) {
                bw.write("5\n1 3 5 7 9\n2 3 4 8 9\n4 5 6 7 8\n4 6 7 8 9\n5 6 7 8 9\n");
            } else {
                bw.write((N / 2 + 1) + "\n");
                for (int i = 1; i <= N; i += 2) {
                    bw.write(i + " ");
                }
                bw.write("\n");
                for (int i = N / 2; i < N; i++) {
                    bw.write(i + " ");
                }
                bw.write("\n");
                bw.write(N / 2 + " ");
                for (int i = N / 2 + 2; i <= N; i++) {
                    bw.write(i + " ");
                }
                bw.write("\n");
                for (int i = N / 2 + 1; i <= N; i++) {
                    bw.write(i + " ");
                }
                bw.write("\n");
            }
        }
        bw.close();
    }
}
