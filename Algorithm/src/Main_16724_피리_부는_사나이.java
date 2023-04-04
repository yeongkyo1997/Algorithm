import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_16724_피리_부는_사나이 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N, M;
    static char[][] field;
    static int[] parent;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        field = new char[N][M];
        parent = new int[N * M];
        for (int i = 0; i < N; i++) {
            field[i] = br.readLine().toCharArray();
        }
        for (int i = 0; i < N * M; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int cur = i * M + j;
                int nx = j + dx[getDir(field[i][j])];
                int ny = i + dy[getDir(field[i][j])];
                int next = ny * M + nx;
                if (next < 0 || next >= N * M) continue;
                union(cur, next);
            }
        }
        int result = 0;
        boolean[] visited = new boolean[N * M];
        for (int i = 0; i < N * M; i++) {
            if (!visited[find(parent[i])]) {
                result++;
                visited[find(parent[i])] = true;
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }

    static int find(int x) {
        if (x == parent[x]) return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return;
        parent[Math.max(a, b)] = Math.min(a, b);
    }

    static int getDir(char c) {
        if (c == 'D') return 0;
        else if (c == 'U') return 1;
        else if (c == 'R') return 2;
        else return 3;
    }
}