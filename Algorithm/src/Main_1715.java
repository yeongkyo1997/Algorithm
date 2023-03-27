import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1715 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(((o1, o2) -> o1 - o2));

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            pq.add(num);
        }
        int sum = 0;
        while (pq.size() > 1) {
            int a;
            a = pq.poll();
            int b = pq.poll();
            sum += a + b;
            pq.add(a + b);
        }

        bw.write(sum + "\n");
        bw.flush();
        bw.close();
    }
}
