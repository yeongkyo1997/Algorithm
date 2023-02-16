import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M;
    static int K;
    static int[][] map;
    static int result;
    static boolean[] check = new boolean[6];
    static List<Info> list = new ArrayList<>();

    static class Info {
        int x;
        int y;
        int size;

        public Info(int x, int y, int size) {
            this.x = x;
            this.y = y;
            this.size = size;
        }

    }

    static void move(int idx, int[][] map) {
        int x = list.get(idx).x;
        int y = list.get(idx).y;
        int s = list.get(idx).size;

        while (s > 0) {
            int tmp = map[x - s][y - s];
            for (int i = x - s; i < x + s; i++) {
                map[i][y - s] = map[i + 1][y - s];
            }
            for (int i = y - s; i < y + s; i++) {
                map[x + s][i] = map[x + s][i + 1];
            }
            for (int i = x + s; i > x - s; i--) {
                map[i][y + s] = map[i - 1][y + s];
            }
            for (int i = y + s; i > y - s; i--) {
                map[x - s][i] = map[x - s][i - 1];
            }
            map[x - s][y - s + 1] = tmp;
            s--;
        }
    }

    static void listCopy(int[][] map, int[][] copyMap) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copyMap[i][j] = map[i][j];
            }
        }
    }

    static void calc(int[][] map) {
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < M; j++) {
                sum += map[i][j];
            }
            result = Math.min(result, sum);
        }
    }

    static void solution(int idx, int[][] map) {
        if (idx == K) {
            calc(map);
            return;
        }

        for (int i = 0; i < K; i++) {
            if (!check[i]) {
                check[i] = true;
                int[][] newMap = new int[50][50];
                listCopy(map, newMap);
                move(i, newMap);
                solution(idx + 1, newMap);
                move(i, newMap);
                check[i] = false;
            }
        }
    }


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        result = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int size = Integer.parseInt(st.nextToken());
            list.add(new Info(x, y, size));
        }
        solution(0, map);
        bw.write(result + "\n");
        bw.close();

    }
}