import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// BOJ 9019 DSLR
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int T;
    static int A, B;
    static boolean[] visited = new boolean[10000];
    static int[] dist = new int[10000];
    static char[] how = new char[10000];
    static int[] from = new int[10000];

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            Arrays.fill(visited, false);
            Arrays.fill(dist, 0);
            Arrays.fill(how, ' ');
            Arrays.fill(from, 0);
            bfs(A);
            print(B);
            bw.write("\n");
        }
        bw.close();
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        dist[start] = 0;
        from[start] = -1;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
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

    static void print(int start) throws IOException {
        if (start == -1) return;
        print(from[start]);
        bw.write(how[start]);
    }
}