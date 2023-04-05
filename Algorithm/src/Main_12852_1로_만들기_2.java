import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_12852_1로_만들기_2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        pq.add(N);

        while (N != 1) {
            if (N % 3 == 0) {
                pq.add(N / 3);
                N /= 3;
            } else if (N % 2 == 0) {
                pq.add(N / 2);
                N /= 2;
            } else {
                N--;
                pq.add(N);
            }
            cnt++;
        }

        bw.write(cnt + "\n");
        while (!pq.isEmpty()) {
            bw.write(pq.poll() + " ");
        }
        bw.close();
    }
}
