package dataStructure;

public class SegmentTree {
    static long[] tree;
    static long[] data;


//    long init(long[] arr, int node, int start, int end) {
//        int mid = (start + end) / 2;
//        if (start == end) return tree[node] = arr[start];
//        else return tree[node] = init(arr, node * 2, start, mid) + init(arr, node, mid + 1, end);
//    }

//    long sum(int node, int start, int end, int left, int right) {
//        int mid = (start + end) / 2;
//        if (end < left || right < start) return 0;
//        else if (left <= start && end <= right) return tree[node];
//        else return sum(node * 2, start, mid, left, right) + sum(node * 2 + 1, mid + 1, end, left, right);
//
//    }

    static long init(long[] arr, int node, int start, int end) {
        int mid = (start + end) / 2;

        if (start == end) return tree[node] = arr[start];

        else return tree[node] = init(arr, node, start, mid) + init(arr, node, mid + 1, end);
    }

    static long sum(int node, int start, int end, int left, int right) {
        int mid = (start + end) / 2;
        if (end < left || right < start) return 0;
        else if (left <= start && end < right) return tree[node];
        else return sum(node * 2, start, mid, left, right) + sum(node * 2 + 1, mid + 1, end, left, right);
    }

    //        void update(int node, int start, int end, int idx, int diff) {
//        if (idx < start || end < idx) return;
//        else {
//            int mid = (start + end) / 2;
//            tree[node] = tree[node] + diff;
//
//            if (start != end) {
//                update(node * 2, start, mid, idx, diff);
//                update(node * 2 + 1, mid + 1, end, idx, diff);
//            }
//        }
//    }
    static void update(int node, int start, int end, int idx, int diff) {
        if (idx < start || end < idx) return;
        else {
            int mid = (start + end) / 2;
            tree[node] = tree[node] + diff;

            if (start != end) {
                update(node * 2, start, mid, idx, diff);
                update(node * 2 + 1, mid + 1, end, idx, diff);
            }
        }
    }
}

