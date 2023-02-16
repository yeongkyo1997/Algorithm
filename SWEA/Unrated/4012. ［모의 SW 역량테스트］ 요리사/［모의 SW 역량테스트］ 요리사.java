import java.io.*;
import java.util.StringTokenizer;

public class Solution {
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
            solution(0, 0);
            bw.write("#" + tc + " " + min + "\n");
        }
        bw.close();
    }

    public static void solution(int start, int depth) {
        if (depth == N / 2) {
            int sum1 = 0, sum2 = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i] && visited[j]) {
                        sum1 += map[i][j];
                    } else if (!visited[i] && !visited[j]) {
                        sum2 += map[i][j];
                    }
                }
            }
            min = Math.min(min, Math.abs(sum1 - sum2));
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
}