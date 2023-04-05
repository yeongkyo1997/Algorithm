import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_19598_최소_회의실_개수 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static int[][] list;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        list = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            list[i][0] = Integer.parseInt(st.nextToken());
            list[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(list, (o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];

            return o1[0] - o2[0];
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            if (pq.isEmpty()) {
                pq.add(list[i][1]);
            } else {
                if (pq.peek() <= list[i][0]) {
                    pq.poll();
                }
                pq.add(list[i][1]);
            }
        }

        bw.write(pq.size() + "");
        bw.close();
    }
}