import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_15773_Touch_The_Sky {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        int[][] a = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            a[i][0] = Integer.parseInt(st.nextToken());
            a[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a, (x, y) -> x[0] + x[1] - y[0] - y[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
        int h = 0;
        for (int i = 0; i < n; i++) {
            h += a[i][1];
            pq.add(a[i][1]);
            if (h > a[i][0] + a[i][1]) {
                h -= pq.poll();
            }
        }
        bw.write(pq.size() + "\n");
        bw.close();
    }
}