package 미제출;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1045_도로 {

    static int[] make_set;
    static long[] ranks;

    public static int find_parents(int X) {
        if (X == make_set[X]) return X;
        make_set[X] = find_parents(make_set[X]);
        return make_set[X];
    }

    public static boolean union(int x, int y) {
        int X = find_parents(x);
        int Y = find_parents(y);

        if (X != Y) {
            if (ranks[X] < ranks[Y]) {
                int temp = X;
                X = Y;
                Y = temp;
            }
            make_set[Y] = X;
            if (ranks[X] == ranks[Y]) {
                ranks[X] += 1;
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<int[]> edgeList = new ArrayList<>();
        for (int x = 0; x < N; x++) {
            String temp = br.readLine();
            for (int y = x + 1; y < N; y++) {
                if (temp.charAt(y) == 'Y') {
                    edgeList.add(new int[]{x, y});
                }
            }
        }

        int cityCnt = 0;
        if (edgeList.size() >= M) {
            int[] result = new int[N];
            make_set = new int[N];
            ranks = new long[N];

            for (int i = 0; i < N; i++) {
                make_set[i] = i;
                ranks[i] = 1;
            }

            PriorityQueue<int[]> remainList = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

            for (int[] edge : edgeList) {
                if (union(edge[0], edge[1])) {
                    cityCnt++;
                    result[edge[1]]++;
                    result[edge[0]]++;
                } else {
                    remainList.add(edge);
                }
            }

            if (cityCnt != N - 1) {
                System.out.println(-1);
            } else {
                int remainCnt = M - cityCnt;

                while (remainCnt > 0) {
                    int[] edge = remainList.poll();
                    result[edge[0]]++;
                    result[edge[1]]++;
                    remainCnt--;
                }

                for (int i = 0; i < N; i++) {
                    System.out.print(result[i] + " ");
                }
            }
        } else {
            System.out.println(-1);
        }
    }
}
