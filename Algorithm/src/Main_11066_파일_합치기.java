import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main_11066_파일_합치기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        while (T-- != 0) {
            int K = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            PriorityQueue<Integer> pq = IntStream.range(0, K).mapToObj(i -> Integer.parseInt(st.nextToken())).collect(Collectors.toCollection(PriorityQueue::new));
            int sum = pq.poll() + pq.poll();
            pq.add(sum);
            while (pq.size() > 1) {
                int tmp = pq.poll() + pq.poll();
                sum += tmp;
                pq.add(tmp);
            }
            bw.write(sum + "\n");
        }
        bw.close();
    }
}
