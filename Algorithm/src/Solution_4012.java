import java.io.*;
import java.util.StringTokenizer;

public class Solution_4012 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, min;
    static int[][] map;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            visited = new boolean[N];
            min = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            solution2(1, 0, 0);
            bw.write("#" + tc + " " + min + "\n");
        }
        bw.close();
    }

    // visited 사용
    public static void solution(int start, int depth) {
        if (depth == N / 2) {
            int s1 = 0, s2 = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i] && visited[j]) {
                        s1 += map[i][j];
                    } else if (!visited[i] && !visited[j]) {
                        s2 += map[i][j];
                    }
                }
            }
            min = Math.min(min, Math.abs(s1 - s2));
            return;
        }
        for (int i = start; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                solution(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }

    // solution2 비트마스킹 사용
    public static void solution2(int start, int depth, int flag) {
        if (depth == N / 2) {
            int s1 = 0, s2 = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if ((flag & 1 << i) != 0 && (flag & 1 << j) != 0) {
                        s1 += map[i][j];
                    } else if ((flag & 1 << i) == 0 && (flag & 1 << j) == 0) {
                        s2 += map[i][j];
                    }
                }
            }
            min = Math.min(min, Math.abs(s1 - s2));
            return;
        }
        for (int i = start; i < N; i++) {
            if ((flag & 1 << i) == 0) {
                solution2(i + 1, depth + 1, flag | 1 << i);
            }
        }
    }
}


