import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    private static int N;
    private static int M;
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) parent[i] = i;

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int connect = Integer.parseInt(st.nextToken());
                if (connect == 1) union(i, j);
            }
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        boolean isPossible = true;

        for (int i = 1; i < M; i++) {
            int next = Integer.parseInt(st.nextToken());
            if (!isSameParent(start, next)) {
                isPossible = false;
                break;
            }
        }

        if (isPossible) bw.write("YES");
        else bw.write("NO");
        bw.close();
    }

    private static int find(int a) {
        if (a == parent[a]) return a;
        return parent[a] = find(parent[a]);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) parent[b] = a;
    }

    private static boolean isSameParent(int a, int b) {
        a = find(a);
        b = find(b);
        return a == b;
    }
}