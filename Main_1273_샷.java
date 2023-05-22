import java.io.*;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main_1273_샷 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M;
    static int[] plusValues = {1, 2, 5};
    static int[] positions = new int[300001];
    static int[] sum = new int[3000000];
    static boolean[] isChecked = new boolean[3000000];

    static class Segment {
        int[] tree;
        int size;

        Segment(int N) {
            size = N;
            tree = new int[4 * N];
        }

        int init(int node, int left, int right) {
            if (left == right) {
                tree[node] = 1;
                return tree[node];
            }

            int mid = (left + right) >> 1;
            tree[node] = init(node * 2, left, mid) + init(node * 2 + 1, mid + 1, right);
            return tree[node];
        }

        void init() {
            init(1, 0, size - 1);
        }

        int update(int index, int value, int node, int left, int right) {
            if (left > index || right < index) return tree[node];

            if (left == right) {
                tree[node] += value;
                return tree[node];
            }

            int mid = (left + right) >> 1;
            tree[node] = update(index, value, node * 2, left, mid) + update(index, value, node * 2 + 1, mid + 1, right);
            return tree[node];
        }

        void update(int index, int value) {
            update(index, value, 1, 0, size - 1);
        }

        int find(int value, int node, int left, int right) {
            if (left == right) return left;

            int mid = (left + right) >> 1;

            if (tree[node * 2] >= value) return find(value, node * 2, left, mid);
            else return find(value - tree[node * 2], node * 2 + 1, mid + 1, right);
        }

        int find(int value) {
            return find(value, 1, 0, size - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        Segment seg = new Segment(3000000);
        seg.init();

        for (int n = 0; n < 3; n++) {
            st = new StringTokenizer(br.readLine());
            for (int m = 0; m < N; m++) {
                int input = Integer.parseInt(st.nextToken());
                sum[positions[m]] += plusValues[n];
                sum[positions[m] + input] -= plusValues[n];
                positions[m] += input;
            }
        }

        IntStream.range(1, 3000000).forEach(n -> sum[n] += sum[n - 1]);

        M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int m = 0; m < M; m++) {
            int input = Integer.parseInt(st.nextToken());
            int index = Math.min(3000000 - 1, seg.find(input));

            if (!isChecked[index]) {
                isChecked[index] = true;
                bw.write(sum[index] + "\n");
                seg.update(index, -1);
            } else {
                bw.write("0\n");
            }
        }
        bw.close();
    }
}