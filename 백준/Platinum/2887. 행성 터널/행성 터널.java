import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[] parent;

    static List<int[]> x = new ArrayList<>();
    static List<int[]> y = new ArrayList<>();
    static List<int[]> z = new ArrayList<>();

    static List<int[]> planet = new ArrayList<>();

    //    행성 터널
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        parent = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            planet.add(new int[] {x, y, z, i});
        }

        planet.sort((o1, o2) -> o1[0] - o2[0]);
        for (int i = 0; i < N - 1; i++) {
            int[] p1 = planet.get(i);
            int[] p2 = planet.get(i + 1);

            x.add(new int[] {Math.abs(p1[0] - p2[0]), p1[3], p2[3]});
        }

        planet.sort((o1, o2) -> o1[1] - o2[1]);
        for (int i = 0; i < N - 1; i++) {
            int[] p1 = planet.get(i);
            int[] p2 = planet.get(i + 1);

            y.add(new int[] {Math.abs(p1[1] - p2[1]), p1[3], p2[3]});
        }

        planet.sort((o1, o2) -> o1[2] - o2[2]);
        for (int i = 0; i < N - 1; i++) {
            int[] p1 = planet.get(i);
            int[] p2 = planet.get(i + 1);

            z.add(new int[] {Math.abs(p1[2] - p2[2]), p1[3], p2[3]});
        }

        List<int[]> list = new ArrayList<>();
        list.addAll(x);
        list.addAll(y);
        list.addAll(z);

        list.sort((o1, o2) -> o1[0] - o2[0]);

        int result = 0;
        for (int[] ints : list) {
            int cost = ints[0];
            int a = ints[1];
            int b = ints[2];

            if (find(a) != find(b)) {
                union(a, b);
                result += cost;
            }
        }

        bw.write(result + "\n");
        bw.close();
    }

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        } else {
            return parent[x] = find(parent[x]);
        }
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            parent[y] = x;
        }
    }
}