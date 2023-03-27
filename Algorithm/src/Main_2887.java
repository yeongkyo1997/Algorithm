import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.prefs.NodeChangeEvent;

public class Main_2887 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static List<Pair> x = new ArrayList<>();
    static List<Pair> y = new ArrayList<>();
    static List<Pair> z = new ArrayList<>();
    static int[] parents = new int[100001];

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int find(int x) {
        if (parents[x] == x)
            return x;
        parents[x] = find(parents[x]);
        return parents[x];
    }

    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA < rootB)
            parents[rootB] = rootA;
        else
            parents[rootA] = rootB;

    }

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            x.add(new Pair(Integer.parseInt(st.nextToken()), i));
            y.add(new Pair(Integer.parseInt(st.nextToken()), i));
            z.add(new Pair(Integer.parseInt(st.nextToken()), i));
        }

        for (int i = 0; i < N; i++) {
        }
    }

}
