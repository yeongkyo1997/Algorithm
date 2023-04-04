import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main_20040_사이클_게임 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int n, m;
    static int[] parent;
    static int endgame = 0;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parent = new int[n];

        IntStream.range(0, n).forEach(i -> parent[i] = i);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b, i + 1);
        }
        bw.write(String.valueOf(endgame));
        bw.close();
    }

    static int find(int a) {
        if (a == parent[a]) {
            return a;
        } else {
            int y = find(parent[a]);
            parent[a] = y;
            return y;
        }
    }

    static void union(int a, int b, int indx) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[Math.max(a, b)] = Math.min(a, b);
        } else if (endgame == 0) {
            endgame = indx;
        }
    }
}