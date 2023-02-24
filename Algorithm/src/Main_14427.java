import java.io.*;
import java.util.StringTokenizer;

public class Main_14427 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static class SegmentTree {
        int[] tree;
        int[] arr;

        public SegmentTree(int[] arr) {
            this.arr = arr;
            tree = new int[arr.length * 4];
            init(1, 1, arr.length - 1);
        }

        public int init(int node, int start, int end) {
            if (start == end) {
                return tree[node] = start;
            }
            int mid = (start + end) / 2;
            int left = init(node * 2, start, mid);
            int right = init(node * 2 + 1, mid + 1, end);
            if (arr[left] <= arr[right]) {
                return tree[node] = left;
            } else {
                return tree[node] = right;
            }
        }

        public int query(int node, int start, int end, int left, int right) {
            if (left > end || right < start) {
                return 0;
            }
            if (left <= start && end <= right) {
                return tree[node];
            }
            int mid = (start + end) / 2;
            int leftNode = query(node * 2, start, mid, left, right);
            int rightNode = query(node * 2 + 1, mid + 1, end, left, right);
            if (leftNode == 0) {
                return rightNode;
            } else if (rightNode == 0) {
                return leftNode;
            } else {
                if (arr[leftNode] <= arr[rightNode]) {
                    return leftNode;
                } else {
                    return rightNode;
                }
            }
        }

        public int update(int node, int start, int end, int index, int value) {
            if (index < start || index > end) {
                return tree[node];
            }

            if (start == end) {
                arr[index] = value;
                return tree[node] = start;
            }
            int mid = (start + end) / 2;
            int left = update(node * 2, start, mid, index, value);
            int right = update(node * 2 + 1, mid + 1, end, index, value);
            if (arr[left] <= arr[right]) {
                return tree[node] = left;
            } else {
                return tree[node] = right;
            }
        }
    }


    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        SegmentTree segmentTree = new SegmentTree(arr);
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == 1) {
                segmentTree.update(1, 1, N, b, Integer.parseInt(st.nextToken()));
            } else {
                bw.write(segmentTree.query(1, 1, N, b, Integer.parseInt(st.nextToken())) + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
