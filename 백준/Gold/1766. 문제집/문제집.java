import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[] inDegree;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static ArrayList<ArrayList<Integer>> graph;
    static int N, M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        inDegree = new int[N + 1];
        graph = new ArrayList<>();

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a, b;
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            inDegree[b]++;
        }

        topologySort();
        bw.flush();
        bw.close();
    }

    static void topologySort() throws IOException {
        for (int i = 1; i < N + 1; i++) {
            if (inDegree[i] == 0)
                pq.add(i);
        }

        while (!pq.isEmpty()) {
            int cur = pq.poll();
            bw.write(cur + " ");

            for (int ele : graph.get(cur)) {
                if (--inDegree[ele] == 0)
                    pq.add(ele);
            }
        }
    }
}
