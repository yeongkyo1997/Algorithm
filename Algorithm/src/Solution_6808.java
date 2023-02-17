import java.io.*;
import java.util.StringTokenizer;

public class Solution_6808 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[] gyu = new int[9];
    static int[] in = new int[9];
    static boolean[] visited;
    static int win, lose;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            boolean[] list = new boolean[18];
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < 9; i++) {
                list[Integer.parseInt(st.nextToken()) - 1] = true;
            }

            int gidx = 0;
            int yidx = 0;
            for (int i = 0; i < 18; i++) {
                if (list[i]) gyu[gidx++] = i + 1;
                else in[yidx++] = i + 1;
            }

            bw.write((t + 1) + "\n");
        }
    }

    // 순열
    public static void dfs(int depth, int score1, int score2) {

    }

    public static void solve(int depth, int flag) {
        if (depth == 9) {

        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

            }
        }
    }
}