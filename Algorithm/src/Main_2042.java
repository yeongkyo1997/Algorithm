import java.io.*;
import java.util.StringTokenizer;

public class Main_2042 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static long[] arr = new long[1000001];
    static long[] tree = new long[3000100];
    static int k;
    static int n;
    static int m;

    static long makeTree(int left, int right, int node) {
        if (left == right) {
            return tree[node] = arr[left];
        } else {
            int mid = (left + right) / 2;
            tree[node] += makeTree(left, mid, node * 2);
            tree[node] += makeTree(mid + 1, right, node * 2 + 1);

            return tree[node];
        }
    }

    static void update(int left, int right, int node, int change, long dif) {
        if (left <= change && change <= right) {
            tree[node] += dif;

            if (left != right) {
                int mid = (left + right) / 2;
                update(left, mid, node * 2, change, dif);
                update(mid + 1, right, node * 2 + 1, change, dif);
            }
        }
    }

    static long sum(int node, int left, int right, int start, int end) {
        if (right < start || end < left) return 0;


        if (start <= left && right <= end) return tree[node];

        int mid = (left + right) / 2;

        return sum(node * 2, left, mid, start, end) + sum(node * 2 + 1, mid + 1, right, start, end);
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 1; i < n + 1; i++)
            arr[i] = Long.parseLong(br.readLine());

        makeTree(1, n, 1);

        for (int i = 0; i < k + m; i++) {
            int cmd, b;
            long c;

            st = new StringTokenizer(br.readLine());
            cmd = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Long.parseLong(st.nextToken());

            if (cmd == 1) {
                long dif = c - arr[b];
                arr[b] = c;
                update(1, n, 1, b, dif);
            } else {
                bw.write(sum(1, 1, n, b, (int) c) + "\n");
            }
        }
        bw.close();
    }
}
