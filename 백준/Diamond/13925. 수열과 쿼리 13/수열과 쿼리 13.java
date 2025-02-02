import java.io.*;
import java.util.*;

public class Main {
    static final long MOD = 1000000007;
    static int N;
    static long[] seg, lazyAdd, lazyMul, lazySet;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(br.readLine().trim());
        long[] arr = new long[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(st.nextToken()) % MOD;
        }
        
        int size = 4 * N;
        seg = new long[size];
        lazyAdd = new long[size];
        lazyMul = new long[size];
        lazySet = new long[size];
        // 초기 lazy 설정: lazyMul는 항등원 1, lazySet는 -1 (할당 없음)으로 초기화
        Arrays.fill(lazyMul, 1);
        Arrays.fill(lazySet, -1);
        
        build(1, 1, N, arr);
        
        int M = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            if (type == 1) { // 덧셈 업데이트
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                long v = Long.parseLong(st.nextToken()) % MOD;
                updateRangeAdd(1, 1, N, l, r, v);
            } else if (type == 2) { // 곱셈 업데이트
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                long v = Long.parseLong(st.nextToken()) % MOD;
                updateRangeMul(1, 1, N, l, r, v);
            } else if (type == 3) { // 할당 업데이트
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                long v = Long.parseLong(st.nextToken()) % MOD;
                updateRangeSet(1, 1, N, l, r, v);
            } else if (type == 4) { // 구간 합 쿼리
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                long res = queryRange(1, 1, N, l, r);
                bw.write(res + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
    
    // 세그먼트 트리 구성
    static void build(int node, int start, int end, long[] arr) {
        if (start == end) {
            seg[node] = arr[start] % MOD;
            return;
        }
        int mid = (start + end) / 2;
        build(node * 2, start, mid, arr);
        build(node * 2 + 1, mid + 1, end, arr);
        seg[node] = (seg[node * 2] + seg[node * 2 + 1]) % MOD;
    }
    
    // lazy 값을 자식 노드로 전파
    static void pushDown(int node, int start, int end) {
        int mid = (start + end) / 2;
        int left = node * 2, right = node * 2 + 1;
        
        // 할당(lazySet)이 있으면 자식 노드에 바로 적용
        if (lazySet[node] != -1) {
            applySet(left, start, mid, lazySet[node]);
            applySet(right, mid + 1, end, lazySet[node]);
            lazySet[node] = -1;
        }
        
        // 곱셈 lazy 전파
        if (lazyMul[node] != 1) {
            applyMul(left, start, mid, lazyMul[node]);
            applyMul(right, mid + 1, end, lazyMul[node]);
            lazyMul[node] = 1;
        }
        
        // 덧셈 lazy 전파
        if (lazyAdd[node] != 0) {
            applyAdd(left, start, mid, lazyAdd[node]);
            applyAdd(right, mid + 1, end, lazyAdd[node]);
            lazyAdd[node] = 0;
        }
    }
    
    // 노드에 할당 연산 적용
    static void applySet(int node, int start, int end, long val) {
        seg[node] = (val * (end - start + 1)) % MOD;
        lazySet[node] = val;
        lazyMul[node] = 1;
        lazyAdd[node] = 0;
    }
    
    // 노드에 곱셈 연산 적용
    static void applyMul(int node, int start, int end, long factor) {
        if (lazySet[node] != -1) {
            lazySet[node] = (lazySet[node] * factor) % MOD;
            seg[node] = (lazySet[node] * (end - start + 1)) % MOD;
        } else {
            lazyMul[node] = (lazyMul[node] * factor) % MOD;
            lazyAdd[node] = (lazyAdd[node] * factor) % MOD;
            seg[node] = (seg[node] * factor) % MOD;
        }
    }
    
    // 노드에 덧셈 연산 적용
    static void applyAdd(int node, int start, int end, long addVal) {
        if (lazySet[node] != -1) {
            lazySet[node] = (lazySet[node] + addVal) % MOD;
            seg[node] = (lazySet[node] * (end - start + 1)) % MOD;
        } else {
            lazyAdd[node] = (lazyAdd[node] + addVal) % MOD;
            seg[node] = (seg[node] + addVal * (end - start + 1)) % MOD;
        }
    }
    
    // 할당 업데이트: [l, r] 구간의 값을 v로 설정
    static void updateRangeSet(int node, int start, int end, int l, int r, long val) {
        if (r < start || end < l) return;
        if (l <= start && end <= r) {
            applySet(node, start, end, val);
            return;
        }
        pushDown(node, start, end);
        int mid = (start + end) / 2;
        updateRangeSet(node * 2, start, mid, l, r, val);
        updateRangeSet(node * 2 + 1, mid + 1, end, l, r, val);
        seg[node] = (seg[node * 2] + seg[node * 2 + 1]) % MOD;
    }
    
    // 곱셈 업데이트: [l, r] 구간의 값을 factor로 곱함
    static void updateRangeMul(int node, int start, int end, int l, int r, long factor) {
        if (r < start || end < l) return;
        if (l <= start && end <= r) {
            applyMul(node, start, end, factor);
            return;
        }
        pushDown(node, start, end);
        int mid = (start + end) / 2;
        updateRangeMul(node * 2, start, mid, l, r, factor);
        updateRangeMul(node * 2 + 1, mid + 1, end, l, r, factor);
        seg[node] = (seg[node * 2] + seg[node * 2 + 1]) % MOD;
    }
    
    // 덧셈 업데이트: [l, r] 구간의 값에 addVal를 더함
    static void updateRangeAdd(int node, int start, int end, int l, int r, long addVal) {
        if (r < start || end < l) return;
        if (l <= start && end <= r) {
            applyAdd(node, start, end, addVal);
            return;
        }
        pushDown(node, start, end);
        int mid = (start + end) / 2;
        updateRangeAdd(node * 2, start, mid, l, r, addVal);
        updateRangeAdd(node * 2 + 1, mid + 1, end, l, r, addVal);
        seg[node] = (seg[node * 2] + seg[node * 2 + 1]) % MOD;
    }
    
    // 구간 합 쿼리: [l, r]의 합을 반환
    static long queryRange(int node, int start, int end, int l, int r) {
        if (r < start || end < l) return 0;
        if (l <= start && end <= r) {
            return seg[node] % MOD;
        }
        pushDown(node, start, end);
        int mid = (start + end) / 2;
        long p = queryRange(node * 2, start, mid, l, r);
        long q = queryRange(node * 2 + 1, mid + 1, end, l, r);
        return (p + q) % MOD;
    }
}