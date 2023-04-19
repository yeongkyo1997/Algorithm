import java.io.*;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main_1005_ACM_Craft {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N, K, W;
    static int[] time, pre;
    static int[][] suc;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            time = new int[N];
            pre = new int[N];
            suc = new int[N][N];

            st = new StringTokenizer(br.readLine());
            IntStream.range(0, N).forEach(i -> time[i] = Integer.parseInt(st.nextToken()));

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken()) - 1;
                int Y = Integer.parseInt(st.nextToken()) - 1;
                suc[X][Y] = 1;
                pre[Y]++;
            }
            W = Integer.parseInt(br.readLine()) - 1;

            int[] result = new int[N];
            int[] queue = new int[N];
            int front = 0, rear = 0;

            for (int i = 0; i < N; i++)
                if (pre[i] == 0) queue[rear++] = i;

            while (pre[W] > 0) {
                int u = queue[front++];
                for (int next = 0; next < N; next++) {
                    if (suc[u][next] == 1) {
                        result[next] = Math.max(result[next], result[u] + time[u]);
                        if (--pre[next] == 0) queue[rear++] = next;
                    }
                }
            }
            bw.write(result[W] + time[W] + "\n");
        }
        bw.close();
    }
}