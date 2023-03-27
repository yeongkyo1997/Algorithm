import java.io.*;
import java.util.StringTokenizer;

public class Main_2357 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static class Node {
        int min;
        int max;

        public Node(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }

    static Node[] tree;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());

        tree = new Node[N * 4];
        init(arr, 0, N - 1, 1);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            Node result = query(0, N - 1, 1, a - 1, b - 1);
            bw.write(result.min + " " + result.max + "\n");
        }
        bw.close();
    }

    static Node init(int[] arr, int start, int end, int node) {
        if (start == end) return tree[node] = new Node(arr[start], arr[start]);

        int mid = (start + end) / 2;
        Node left = init(arr, start, mid, node * 2);
        Node right = init(arr, mid + 1, end, node * 2 + 1);

        return tree[node] = new Node(Math.min(left.min, right.min), Math.max(left.max, right.max));
    }

    static Node query(int start, int end, int node, int left, int right) {
        if (right < start || left > end) return new Node(Integer.MAX_VALUE, Integer.MIN_VALUE);
        if (left <= start && end <= right) return tree[node];

        int mid = (start + end) / 2;
        Node lNode = query(start, mid, node * 2, left, right);
        Node rNode = query(mid + 1, end, node * 2 + 1, left, right);

        return new Node(Math.min(lNode.min, rNode.min), Math.max(lNode.max, rNode.max));
    }
}
