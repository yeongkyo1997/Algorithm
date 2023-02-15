import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static String[] WB = {
            "WBWBWBWB",
            "BWBWBWBW",
            "WBWBWBWB",
            "BWBWBWBW",
            "WBWBWBWB",
            "BWBWBWBW",
            "WBWBWBWB",
            "BWBWBWBW",
    };
    static String[] BW = {
            "BWBWBWBW",
            "WBWBWBWB",
            "BWBWBWBW",
            "WBWBWBWB",
            "BWBWBWBW",
            "WBWBWBWB",
            "BWBWBWBW",
            "WBWBWBWB",
    };

    static String[] board;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N, M;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new String[N];
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine();
        }

        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                result = Math.min(Math.min(WBcnt(i, j), BWcnt(i, j)), result);
            }
        }

        bw.write(result + "");
        bw.flush();
        bw.close();
    }

    static int WBcnt(int x, int y) {
        int result = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[x + i].charAt(j + y) != WB[i].charAt(j))
                    result++;
            }
        }
        return result;
    }

    static int BWcnt(int x, int y) {
        int result = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[x + i].charAt(j + y) != BW[i].charAt(j))
                    result++;
            }
        }
        return result;
    }
}
