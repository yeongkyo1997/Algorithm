import java.io.*;
import java.util.StringTokenizer;

// SW Expert Academy 3289. 서로소 집합
public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int[] parent;
    static int N, M;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            parent = new int[N + 1];
            makeSet();

            bw.write("#" + tc + " ");
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int op = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if (op == 0) {
                    union(a, b);
                } else {
                    if (find(a) == find(b)) {
                        bw.write("1");
                    } else {
                        bw.write("0");
                    }
                }
            }
            bw.write("\n");
        }
        bw.close();
    }

    static void makeSet() {
        for (int i = 1; i <= N; i++)
            parent[i] = i;
    }

    static int find(int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if (aRoot == bRoot) return;

        parent[bRoot] = aRoot;
    }
}