import java.io.*;
import java.util.*;

public class Main_18352_특정_거리의_도시_찾기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[] dist;
    static List<List<Integer>> list = new ArrayList<>();
    private static int X;
    private static int N;
    private static int M;
    private static int K;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        Arrays.fill(dist, 987654321);
    }

    static void dijstra(int X) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        dist[X] = 0;
        pq.add(X);

        while (!pq.isEmpty()) {

        }
    }
}
