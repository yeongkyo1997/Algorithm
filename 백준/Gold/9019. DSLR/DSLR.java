import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    private static int T;
    private static int A;
    private static int B;
    private static boolean[] visited;
    private static int[] dist;

    private static char[] how;
    private static int[] from;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            visited = new boolean[10000];
            dist = new int[10000];
            how = new char[10000];
            from = new int[10000];
            bfs();
            print(B);
            bw.write("\n");
        }
        bw.close();
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(A);
        visited[A] = true;
        dist[A] = 0;
        from[A] = -1;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            if (cur == B) return;

            int next = (cur * 2) % 10000;

            if (!visited[next]) {
                queue.add(next);
                visited[next] = true;
                dist[next] = dist[cur] + 1;
                from[next] = cur;
                how[next] = 'D';
            }

            next = cur - 1;

            if (next == -1) next = 9999;

            if (!visited[next]) {
                queue.add(next);
                visited[next] = true;
                dist[next] = dist[cur] + 1;
                from[next] = cur;
                how[next] = 'S';
            }

            next = (cur % 1000) * 10 + cur / 1000;

            if (!visited[next]) {
                queue.add(next);
                visited[next] = true;
                dist[next] = dist[cur] + 1;
                from[next] = cur;
                how[next] = 'L';
            }

            next = (cur % 10) * 1000 + cur / 10;
            if (!visited[next]) {
                queue.add(next);
                visited[next] = true;
                dist[next] = dist[cur] + 1;
                from[next] = cur;
                how[next] = 'R';
            }
        }
    }

    private static void print(int n) throws IOException {
        if (n == -1) return;
        print(from[n]);
        if (how[n] != '\0')
            bw.write(how[n] + "");
    }
}