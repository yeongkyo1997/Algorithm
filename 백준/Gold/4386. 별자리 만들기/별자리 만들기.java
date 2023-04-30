import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[] p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        p = new int[N];
        double[][] stars = new double[N][2];
        for (int i = 0; i < N; i++) {
            p[i] = i;
            StringTokenizer st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            stars[i][0] = x;
            stars[i][1] = y;
        }
        PriorityQueue<double[]> pq = new PriorityQueue<>((o1, o2) -> (int) (o1[0] - o2[0]));
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                pq.offer(new double[]{getDistance(stars[i], stars[j]), i, j});
            }
        }
        int count = N - 1;
        double answer = 0;
        while (!pq.isEmpty() && count > 0) {
            double[] now = pq.poll();
            int x = (int) now[1];
            int y = (int) now[2];

            if (!isSameParent(x, y)) {
                count--;
                union(x, y);
                answer += now[0];
            }
        }
        System.out.printf("%f", answer);
    }

    static double getDistance(double[] a, double[] b) {
        return Math.sqrt(Math.pow(b[0] - a[0], 2) + Math.pow(b[1] - a[1], 2));
    }

    static int find(int x) {
        if (x == p[x]) return x;
        return p[x] = find(p[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x <= y) p[y] = x;
        else p[x] = y;
    }

    static boolean isSameParent(int x, int y) {
        return find(x) == find(y);
    }
}