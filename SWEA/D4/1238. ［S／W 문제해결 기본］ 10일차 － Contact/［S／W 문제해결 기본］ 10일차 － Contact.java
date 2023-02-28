import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int len, start, result, max;
    static Queue<Integer> queue;
    static ArrayList<Integer>[] graph;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        for (int tc = 1; tc <= 10; tc++) {

            st = new StringTokenizer(br.readLine());
            len = Integer.parseInt(st.nextToken()) / 2;
            start = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            visited = new int[101];
            graph = new ArrayList[101];
            result = 0;
            max = 0;

            for (int i = 0; i < 101; i++) graph[i] = new ArrayList<>();
            for (int i = 0; i < len; i++) graph[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));

            queue = new ArrayDeque<>();
            queue.add(start);
            visited[start] = 1;

            while (!queue.isEmpty()) {
                int x = queue.poll();
                for (int i : graph[x]) {
                    if (visited[i] == 0) {
                        visited[i] = visited[x] + 1;
                        queue.add(i);
                    }
                }
            }

            for (int i = 0; i < visited.length; i++) {
                if (visited[i] >= max) {
                    max = visited[i];
                    result = Math.max(result, i);
                }
            }
            bw.write(String.format("#%d %d\n", tc, result));
        }
        bw.close();
    }
}