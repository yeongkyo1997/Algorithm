import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main_1516_게임_개발 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N;
    static int[] entry, bTime, result;
    static List<Integer>[] list;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        entry = new int[N + 1];
        bTime = new int[N + 1];
        result = new int[N + 1];
        list = new List[N + 1];

        IntStream.rangeClosed(1, N).forEach(i -> list[i] = new LinkedList<>());

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            bTime[i] = Integer.parseInt(st.nextToken());

            while (true) {
                int a = Integer.parseInt(st.nextToken());
                if (a == -1) break;
                list[a].add(i);
                entry[i]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (entry[i] == 0) {
                queue.add(i);
                result[i] = bTime[i];
            }
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int i = 0; i < list[cur].size(); i++) {
                int next = list[cur].get(i);
                entry[next]--;

                result[next] = Math.max(result[next], result[cur] + bTime[next]);
                if (entry[next] == 0) queue.add(next);
            }
        }

        IntStream.rangeClosed(1, N).map(i -> result[i]).forEach(System.out::println);
    }
}