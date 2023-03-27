import java.io.*;
import java.util.StringTokenizer;

// BOJ 4803번 트리
public class Main_4803 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int t = 1;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if (n == 0 && m == 0) break;
            int[] parent = new int[n + 1];

            for (int i = 1; i < n + 1; i++) parent[i] = i;

            int cnt = n;
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if (find(parent, a) != find(parent, b)) {
                    union(parent, a, b);
                    cnt--;
                }
            }
            bw.write("Case " + t + ": ");
            switch (cnt) {
                case 0:
                    bw.write("No trees.");
                    break;
                case 1:
                    bw.write("There is one tree.");
                    break;
                default:
                    bw.write("A forest of " + cnt + " trees.");
                    break;
            }

            bw.newLine();
            t++;
        }
        bw.flush();
        bw.close();

    }

    static int find(int[] parent, int x) {
        if (parent[x] == x) return x;
        else return parent[x] = find(parent, parent[x]);
    }

    static void union(int[] parent, int a, int b) {
        a = find(parent, a);
        b = find(parent, b);
        if (a < b) parent[b] = a;
        else parent[a] = b;
    }
}
