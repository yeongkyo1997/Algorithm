import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_4386 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[] parent;
    static int V;
    static PriorityQueue<Connect> pq = new PriorityQueue<>();
    static Point[] points;
    private static int cnt;

    static class Point {
        int num;
        double x;
        double y;

        public Point(int num, double x, double y) {
            this.num = num;
            this.x = x;
            this.y = y;
        }
    }

    static class Connect implements Comparable<Connect> {
        Point start;
        Point end;

        public Connect(Point start, Point end) {
            this.start = start;
            this.end = end;
        }

        double getDistance() {
            return Math.sqrt(Math.pow(start.x - end.x, 2) + Math.pow(start.y - end.y, 2));
        }

        @Override
        public int compareTo(Connect o) {
            return (int) (this.getDistance() - o.getDistance());
        }
    }

    static int find(int a) {
        return a == parent[a] ? a : (parent[a] = find(parent[a]));
    }

    static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot != bRoot) parent[aRoot] = bRoot;
    }

    static void init() {
        parent = new int[V + 1];
        for (int i = 1; i < V + 1; i++)
            parent[i] = i;
    }

    static double kru() {
        double result = 0f;
        int cnt = 0;

        while (!pq.isEmpty()) {
            Connect cur = pq.poll();
            int a = find(cur.start.num);
            int b = find(cur.end.num);

            if (a == b) continue;
            union(a, b);
            result += cur.getDistance();

            if (++cnt == V) break;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        V = Integer.parseInt(br.readLine());
        points = new Point[V + 1];

        init();

        for (int i = 1; i < V + 1; i++) {
            st = new StringTokenizer(br.readLine());
            points[i] = new Point(i, Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
        }

        for (int i = 1; i < V + 1; i++) {
            for (int j = i + 1; j < V + 1; j++) {
                pq.add(new Connect(points[i], points[j]));
            }
        }

        bw.write(kru() + "");
        bw.close();
    }
}
