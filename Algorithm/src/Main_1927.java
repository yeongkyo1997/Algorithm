import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1927 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) bw.write(pq.isEmpty() ? 0 + "\n" : pq.poll() + "\n");
            else pq.add(num);
        }
        bw.close();
    }
}
