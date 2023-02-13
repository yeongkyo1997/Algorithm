import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_12851 {
    public static final int MAX_SIZE = 100001;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static class Pair {
        int pos;
        int length;

        public Pair(int pos, int length) {
            this.pos = pos;
            this.length = length;
        }
    }

    public static void main(String[] args) throws IOException {
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> {
            if (p1.length == p2.length) return p2.pos - p1.pos;
            else {
                return p1.length - p2.length;
            }
        });
        boolean[] visited = new boolean[MAX_SIZE];
        int min = 0;
        st = new StringTokenizer(br.readLine());
        int N, K;
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        pq.add(new Pair(N, 0));
        int cnt = 0;
        boolean isFind = false;
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int pos = p.pos;
            int length = p.length;
            visited[pos] = true;
            if (isFind && length > min) break;

            if (pos == K && (!isFind || length == min)) {
                min = length;
                cnt++;
                isFind = true;
            }
            if (pos + 1 < MAX_SIZE && !visited[pos + 1]) {
                pq.add(new Pair(pos + 1, length + 1));
            }
            if (pos - 1 >= 0 && !visited[pos - 1]) {
                pq.add(new Pair(pos - 1, length + 1));
            }
            if (pos * 2 < MAX_SIZE && !visited[pos * 2]) {
                pq.add(new Pair(pos * 2, length + 1));
            }
        }
        bw.write(min + "\n" + cnt);
        bw.flush();
        bw.close();
    }
}
