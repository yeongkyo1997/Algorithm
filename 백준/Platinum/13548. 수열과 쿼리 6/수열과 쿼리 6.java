import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int[] freq;
    static int[] freqCount;
    static int currentMax = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        Query[] queries = new Query[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int l = Integer.parseInt(st.nextToken()) - 1;
            int r = Integer.parseInt(st.nextToken()) - 1;
            queries[i] = new Query(l, r, i);
        }

        int blockSize = (int) Math.sqrt(N);
        Arrays.sort(queries, new Comparator<Query>() {
            public int compare(Query q1, Query q2) {
                int block1 = q1.l / blockSize;
                int block2 = q2.l / blockSize;
                if (block1 == block2)
                    return Integer.compare(q1.r, q2.r);
                return Integer.compare(block1, block2);
            }
        });

        freq = new int[100001];
        freqCount = new int[N + 1];
        currentMax = 0;

        int currentL = 0, currentR = -1;
        int[] ans = new int[M];

        for (Query q : queries) {
            while (currentR < q.r) {
                currentR++;
                add(arr[currentR]);
            }
            while (currentR > q.r) {
                remove(arr[currentR]);
                currentR--;
            }
            while (currentL < q.l) {
                remove(arr[currentL]);
                currentL++;
            }
            while (currentL > q.l) {
                currentL--;
                add(arr[currentL]);
            }
            ans[q.idx] = currentMax;
        }

        for (int i = 0; i < M; i++) {
            bw.write(ans[i] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void add(int x) {
        int oldFreq = freq[x];
        int newFreq = oldFreq + 1;
        freq[x] = newFreq;
        freqCount[newFreq]++;
        if (oldFreq > 0) {
            freqCount[oldFreq]--;
        }
        if (newFreq > currentMax)
            currentMax = newFreq;
    }

    static void remove(int x) {
        int oldFreq = freq[x];
        int newFreq = oldFreq - 1;
        freq[x] = newFreq;
        freqCount[oldFreq]--;
        if (newFreq > 0) {
            freqCount[newFreq]++;
        }
        if (oldFreq == currentMax && freqCount[oldFreq] == 0)
            currentMax--;
    }

    static class Query {
        int l, r, idx;

        Query(int l, int r, int idx) {
            this.l = l;
            this.r = r;
            this.idx = idx;
        }
    }
}