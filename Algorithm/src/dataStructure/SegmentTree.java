package dataStructure;

public class SegmentTree {
    private long[] tree;

    public SegmentTree(int n) {
        double treeHeight = Math.ceil(Math.log(n) / Math.log(2)) + 1;
        long treeNodeCnt = Math.round(Math.pow(2, treeHeight));
        tree = new long[Math.toIntExact(treeNodeCnt)];
    }

    long init(long[] arr, int node, int start, int end) {
        if (start == end) {
            return tree[node] = arr[start];
        } else {
            int mid = (start + end) / 2;
            return tree[node] = init(arr, node * 2, start, mid) + init(arr, node * 2 + 1, mid, end);
        }
    }

    long sum(int node, int start, int end, int left, int right) {
        if (end < left || right < start) return 0;
        else if (left <= start && end <= right) return tree[node];
        else {
            int mid = (start + end) / 2;
            return sum(node * 2, start, mid, left, right) + sum(node * 2 + 1, mid, end, left, right);
        }
    }
}

