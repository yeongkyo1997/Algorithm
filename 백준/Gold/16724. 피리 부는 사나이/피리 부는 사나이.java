import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N, M;
    static char[][] field; // 지도
    static int[] parent; // 부모 노드
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        field = new char[N][M];
        parent = new int[N * M]; // 부모 노드

        for (int i = 0; i < N; i++)
            field[i] = br.readLine().toCharArray();

        IntStream.range(0, N * M).forEach(i -> parent[i] = i); // 부모 노드 초기화


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int cur = i * M + j; // 현재 노드
                int nx = j + dx[getDir(field[i][j])]; // 다음 x좌표
                int ny = i + dy[getDir(field[i][j])]; // 다음 y좌표
                int next = ny * M + nx; // 다음 노드
                if (next < 0 || next >= N * M) continue; // 범위를 벗어나면 continue
                if (find(cur) != find(next)) union(cur, next);
            }
        }

        int result = 0; // 결과
        boolean[] visited = new boolean[N * M]; // 방문 여부
        for (int i = 0; i < N * M; i++) { // 부모 노드를 찾아서 방문 여부를 체크
            if (!visited[find(parent[i])]) {
                result++;
                visited[find(parent[i])] = true;
            }
        }

        bw.write(String.valueOf(result));
        bw.close();
    }

    static int find(int a) {
        if (a == parent[a]) return a;
        parent[a] = find(parent[a]);
        return parent[a];
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return;
        parent[Math.max(a, b)] = Math.min(a, b);
    }

    static int getDir(char c) { // 방향을 숫자로 변환
        if (c == 'D') return 0;
        else if (c == 'U') return 1;
        else if (c == 'R') return 2;
        else return 3;
    }
}