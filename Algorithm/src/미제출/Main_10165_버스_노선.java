package 미제출;

import java.io.*;
import java.util.*;

public class Main_10165_버스_노선 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static class Pair {
        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static class Triple {
        Pair pair;
        int index;

        Triple(Pair pair, int index) {
            this.pair = pair;
            this.index = index;
        }
    }

    public static void main(String[] args) throws IOException {
        int N, M;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        List<Triple> v = new ArrayList<>();
        boolean[] visit = new boolean[500011];

        for (int i = 0; i < M; i++) {
            int a, b;
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            if (a < b) {
                v.add(new Triple(new Pair(a, b), i));
                v.add(new Triple(new Pair(a + N, b + N), i));
            } else v.add(new Triple(new Pair(a, b + N), i));
        }

        v.sort((p1, p2) -> {
            if (p1.pair.first == p2.pair.first) {
                return Integer.compare(p2.pair.second, p1.pair.second);
            }
            return Integer.compare(p1.pair.first, p2.pair.first);
        });

        int s, e, left = 0, right = 0;
        for (Triple triple : v) {
            s = triple.pair.first;
            e = triple.pair.second;
            int idx = triple.index;

            if (visit[idx]) continue;

            if (left <= s && e <= right) {
                visit[idx] = true;
                continue;
            }

            left = s;
            right = e;
        }

        for (int i = 0; i < M; i++) {
            if (!visit[i]) {
                bw.write((i + 1) + " ");
            }
        }
        bw.close();
    }
}
