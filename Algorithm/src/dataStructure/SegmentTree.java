package dataStructure;

public class SegmentTree {
    static long[] tree;
    static long[] arr;
    static int N;

    static long init(long[] arr, int node, int start, int end) {
        if (start == end) return tree[node] = arr[start];

        return tree[node] = init(arr, node * 2, start, (start + end) / 2);
    }

    public static void main(String[] args) {
    }
}

