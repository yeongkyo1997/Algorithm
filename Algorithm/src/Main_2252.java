import java.io.*;
import java.util.*;

public class Main_2252 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<List<Integer>> list = new ArrayList<>();
        int[] edgeCount = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            edgeCount[b]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i < N + 1; i++) {
            if (edgeCount[i] == 0) queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            bw.write(cur + " ");

            List<Integer> tmp = list.get(cur);

            for (Integer ele : tmp) {
                if (--edgeCount[ele] == 0) queue.offer(ele);
            }
        }

        bw.close();
    }
}
