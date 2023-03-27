import java.io.*;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main_1074 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[] list = new int[16];

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        list[0] = 1;
        IntStream.range(1, 16).forEach(i -> list[i] = list[i - 1] * 2);
        bw.write(Z(N, r, c) - 1 + "");
        bw.close();
    }

    static int Z(int N, int r, int c) {
        return N == 0 ? 1 : r < list[N - 1] ? c < list[N - 1] ? Z(N - 1, r, c) : list[N - 1] * list[N - 1] + Z(N - 1, r, c - list[N - 1]) : c < list[N - 1] ? list[N - 1] * list[N - 1] * 2 + Z(N - 1, r - list[N - 1], c) : list[N - 1] * list[N - 1] * 3 + Z(N - 1, r - list[N - 1], c - list[N - 1]);
    }
}
