import java.io.*;
import java.util.StringTokenizer;

public class Main_11729 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int cnt;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        bw.write(((1 << N) - 1) + "\n");
        hanoi(N, 1, 2, 3);
        bw.close();
    }

    static void hanoi(int depth, int start, int mid, int end) throws IOException {
        if (depth == 1) {
            bw.write(start + " " + end + "\n");
            return;
        }

        hanoi(depth - 1, start, end, mid);
        bw.write(start + " " + end + "\n");
        hanoi(depth - 1, mid, start, end);
    }
}
