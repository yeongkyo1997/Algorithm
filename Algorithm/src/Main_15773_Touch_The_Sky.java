//from heapq import *
//        pq = []
//        height = 0
//        n = int(input())
//        balloon = sorted([list(map(int, input().split())) for _ in range(n)], key=lambda x: sum(x))
//        for l, d in balloon:
//        height += d
//        heappush(pq, -d)
//        if height > l + d:
//        height += heappop(pq)
//        print(len(pq))

//py3 to java

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_15773_Touch_The_Sky {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static PriorityQueue<Long> pq = new PriorityQueue<>();
    static long height = 0;
    static int n;
    static long[][] balloon;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        balloon = new long[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            balloon[i][0] = Integer.parseInt(st.nextToken());
            balloon[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(balloon, (o1, o2) -> Long.compare(o1[0] + o1[1], o2[0] - o2[1]));
        for (int i = 0; i < n; i++) {
            height += balloon[i][1];
            pq.add(-balloon[i][1]);
            if (height > balloon[i][0] + balloon[i][1]) {
                height += pq.poll();
            }
        }
        bw.write(pq.size() + "\n");
        bw.close();
    }
}
