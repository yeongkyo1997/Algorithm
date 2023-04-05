import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

import static java.util.stream.IntStream.range;

public class Main_24444_알고리즘_수업_너비_우선_탐색_1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M;
    static List<List<Integer>> list = new ArrayList<>();
    static int[] visited;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        visited = new int[N + 1];

        range(0, N + 1).forEach(i -> list.add(new ArrayList<>()));

        visited = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }


        list.forEach(Collections::sort);

        bfs(R);

        for (int i = 1; i < N + 1; i++) {
            bw.write(visited[i] + "\n");

        }
        bw.close();
    }

    static void bfs(int start) {
        int head = 0;
        int tail = 0;
        int[] queue = new int[N + 1];
        int cnt = 1;
        visited[start] = cnt++;

        queue[tail++] = start;

        while (head < tail) {
            int cur = queue[head++];
            for (int i = 0; i < list.get(cur).size(); i++) {
                int next = list.get(cur).get(i);
                if (visited[next] != 0) continue;
                visited[next] = cnt++;
                queue[tail++] = next;
            }
        }
    }
}