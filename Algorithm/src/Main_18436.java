import java.io.*;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

// 백준 18436번 - 수열과 쿼리 37
public class Main_18436 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M;
    static int[] arr;
    static int[] tree;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        tree = new int[N * 4];

        st = new StringTokenizer(br.readLine());
        IntStream.rangeClosed(1, N).forEach(i -> arr[i] = Integer.parseInt(st.nextToken()));

        init(1, N, 1);

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            if (a == 1) change(1, N, 1, b, x);
            else {
                int result = query(1, N, 1, b, x);
                bw.write(result + "\n");
            }
        }

        bw.close();
    }

    static int init(int start, int end, int node) {
        if (start == end) {
            if (arr[start] % 2 == 0) return tree[node] = 1;
            return tree[node] = 0;
        }
        int mid = (start + end) / 2;
        return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
    }

    static int query(int start, int end, int node, int left, int right) {
        if (right < start || left > end) return 0;
        if (left <= start && end <= right) return tree[node];
        int mid = (start + end) >> 1;
        return query(start, mid, node * 2, left, right) + query(mid + 1, end, node * 2 + 1, left, right);
    }

    static int change(int start, int end, int node, int idx, int val) {
        if (idx < start || idx > end) return tree[node];
        if (start == end) {
            if (val % 2 == 0) return tree[node] = 1;
            return tree[node] = 0;
        }
        int mid = (start + end) >> 1;
        return tree[node] = change(start, mid, node * 2, idx, val) + change(mid + 1, end, node * 2 + 1, idx, val);
    }
}
