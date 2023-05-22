
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1648_격자판_채우기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static final int MAX = 14;
    static final int MOD = 9901;

    static int N, M;
    static int[][] cache = new int[MAX * MAX][1 << MAX];

    public static int tiling(int board, int bit) {
        if (board == N * M && bit == 0) return 1;

        if (board >= N * M) return 0;

        int result = cache[board][bit];
        if (result != -1) return result;

        if ((bit & 1) == 1) result = tiling(board + 1, (bit >> 1));
        else {
            result = tiling(board + 1, (bit >> 1) | (1 << (M - 1)));

            if ((board % M) != (M - 1) && (bit & 2) == 0) result += tiling(board + 2, bit >> 2);
        }

        return cache[board][bit] = result % MOD;
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Arrays.stream(cache).forEach(row -> Arrays.fill(row, -1));

        bw.write(tiling(0, 0) + "\n");
        bw.close();
    }
}
