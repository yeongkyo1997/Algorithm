import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        bw.write(sol(N, r, c) + "");
        bw.close();
    }

    static int sol(int N, int r, int c) {
        return N == 0 ? 0 : 2 * (r % 2) + (c % 2) + 4 * sol(N - 1, r / 2, c / 2);
    }
}