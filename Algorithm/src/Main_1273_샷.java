import java.io.*;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main_1273_샷 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M;
    static int[] Plus = {1, 2, 5};
    static int[] p = new int[300001];
    static int[] sum = new int[3000000];
    static boolean[] chk = new boolean[3000000];

    static class Segment {
        int[] tree;
        int size;

        Segment(int N) {
            size = N;
            tree = new int[4 * N];
        }

        int init(int node, int nl, int nr) {
            if (nl == nr) {
                tree[node] = 1;
                return tree[node];
            }

            int mid = (nl + nr) >> 1;
            tree[node] = init(node * 2, nl, mid) + init(node * 2 + 1, mid + 1, nr);
            return tree[node];
        }

        void init() {
            init(1, 0, size - 1);
        }

        int update(int idx, int val, int node, int nl, int nr) {
            if (nl > idx || nr < idx) return tree[node];

            if (nl == nr) {
                tree[node] += val;
                return tree[node];
            }

            int mid = (nl + nr) >> 1;
            tree[node] = update(idx, val, node * 2, nl, mid) + update(idx, val, node * 2 + 1, mid + 1, nr);
            return tree[node];
        }

        void update(int idx, int val) {
            update(idx, val, 1, 0, size - 1);
        }

        int find(int val, int node, int nl, int nr) {
            if (nl == nr) return nl;

            int mid = (nl + nr) >> 1;

            if (tree[node * 2] >= val) return find(val, node * 2, nl, mid);
            else return find(val - tree[node * 2], node * 2 + 1, mid + 1, nr);
        }

        int find(int val) {
            return find(val, 1, 0, size - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        Segment seg = new Segment(3000000);
        seg.init();

        for (int n = 0; n < 3; n++) {
            st = new StringTokenizer(br.readLine());
            for (int m = 0; m < N; m++) {
                int in = Integer.parseInt(st.nextToken());
                sum[p[m]] += Plus[n];
                sum[p[m] + in] -= Plus[n];
                p[m] += in;
            }
        }

        IntStream.range(1, 3000000).forEach(n -> sum[n] += sum[n - 1]);

        M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int m = 0; m < M; m++) {
            int in = Integer.parseInt(st.nextToken());
            int idx = Math.min(3000000 - 1, seg.find(in));

            if (!chk[idx]) {
                chk[idx] = true;
                bw.write(sum[idx] + "\n");
                seg.update(idx, -1);
            } else {
                bw.write("0\n");
            }
        }
        bw.close();
    }
}
