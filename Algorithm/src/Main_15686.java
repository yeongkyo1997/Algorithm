import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_15686 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static final int INF = 987654321;
    static int[][] map;
    static int N, M;
    static List<int[]> chicken = new ArrayList<>();
    static List<int[]> house = new ArrayList<>();
    static int[] selected;
    static int min = INF;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        selected = new int[M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) house.add(new int[]{i, j});
                else if (map[i][j] == 2) chicken.add(new int[]{i, j});
            }
        }
        comb(0, 0);
        bw.write(min + "\n");
        bw.close();
    }

    static void comb(int idx, int cnt) {
        if (cnt == M) {
            int sum = 0;
            for (int i = 0; i < house.size(); i++) {
                int[] h = house.get(i);
                int minDist = INF;
                for (int j = 0; j < M; j++) {
                    int[] c = chicken.get(selected[j]);
                    minDist = Math.min(minDist, Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]));
                }
                sum += minDist;
            }
            min = Math.min(min, sum);
            return;
        }
        if (idx == chicken.size()) return;
        selected[cnt] = idx;
        comb(idx + 1, cnt + 1);
        comb(idx + 1, cnt);
    }
}