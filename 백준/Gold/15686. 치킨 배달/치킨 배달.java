import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M;
    static int[][] map;
    static Point[] choice;
    static ArrayList<Point> chicken = new ArrayList<>();
    static ArrayList<Point> home = new ArrayList<>();
    static int result = Integer.MAX_VALUE;

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) chicken.add(new Point(i, j));
                else if (map[i][j] == 1) home.add(new Point(i, j));
            }
        }

        choice = new Point[M];
        combi(0, 0);
        bw.write(result + "\n");
        bw.close();
    }

    static void combi(int depth, int start) {
        if (depth == M) {
            int sum = 0;
            for (Point value : home) {
                int min = Integer.MAX_VALUE;
                for (Point point : choice) {
                    min = Math.min(min, getDist(point, value));
                }
                sum += min;
            }
            result = Math.min(sum, result);
            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            choice[depth] = chicken.get(i);
            combi(depth + 1, i + 1);
        }
    }

    static int getDist(Point p1, Point p2) {
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }
}