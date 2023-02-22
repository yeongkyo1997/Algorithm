import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static boolean[][] visited = new boolean[500001][2];

    static class Pair {
        int pos;
        int depth;

        public Pair(int pos, int depth) {
            this.pos = pos;
            this.depth = depth;
        }
    }

    static public void main(String[] args) throws IOException {
        int N, K;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited[N][0] = true;

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(N, 0));

        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            int cur = p.pos;
            int depth = p.depth;
            int bro = K + (depth * (depth + 1)) / 2;

            if (bro > 500000) {
                bw.write("-1");
                break;
            }

            if (cur == bro || visited[bro][depth % 2]) {
                bw.write(depth + "");
                break;
            }
            for (int nxt : new int[]{cur - 1, cur + 1, cur * 2}) {
                if (nxt >= 0 && nxt <= 500000 && !visited[nxt][(depth + 1) % 2]) {
                    queue.add(new Pair(nxt, depth + 1));
                    visited[nxt][(depth + 1) % 2] = true;
                }
            }
        }
        bw.flush();
        bw.close();
    }
}