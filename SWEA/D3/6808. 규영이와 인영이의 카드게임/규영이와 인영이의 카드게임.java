import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int[] gyu = new int[9];
    static int[] in = new int[9];
    static boolean[] visited;
    static int win, lose;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            visited = new boolean[19];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 9; i++) {
                gyu[i] = Integer.parseInt(st.nextToken());
                visited[gyu[i]] = true;
            }
            int idx = 0;
            for (int i = 1; i <= 18; i++) {
                if (!visited[i]) {
                    in[idx++] = i;
                }
            }
            win = 0;
            lose = 0;
            // dfs(0, 0, 0);
            dfs2(0, 0, 0, 0);

            bw.write("#" + tc + " " + win + " " + lose + "\n");
        }
        bw.close();
    }

    public static void dfs(int depth, int score1, int score2) {
        if (depth == 9) {
            if (score1 > score2) {
                win++;
            } else if (score1 < score2) {
                lose++;
            }
            return;
        }
        for (int i = 0; i < 9; i++) {
            if (!visited[in[i]]) {
                visited[in[i]] = true;
                if (gyu[depth] > in[i]) {
                    dfs(depth + 1, score1 + gyu[depth] + in[i], score2);
                } else if (gyu[depth] < in[i]) {
                    dfs(depth + 1, score1, score2 + gyu[depth] + in[i]);
                }
                visited[in[i]] = false;
            }
        }
    }

    // 비트 마스킹 사용
    public static void dfs2(int depth, int score1, int score2, int flag) {
        if (depth == 9) {
            if (score1 > score2) {
                win++;
            } else if (score1 < score2) {
                lose++;
            }
            return;
        }
        for (int i = 0; i < 9; i++) {
            if ((flag & 1 << in[i]) == 0) {
                if (gyu[depth] > in[i]) {
                    dfs2(depth + 1, score1 + gyu[depth] + in[i], score2, flag | 1 << in[i]);
                } else if (gyu[depth] < in[i]) {
                    dfs2(depth + 1, score1, score2 + gyu[depth] + in[i], flag | 1 << in[i]);
                }
            }
        }
    }

}