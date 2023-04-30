package daily_workshop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] degree = new int[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] algoSpots = new char[N][];
        boolean[] visited = new boolean[26];
        List<Integer>[] graph = new List[26];
        Queue<Integer> queue = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int count = 0;

        for (int i = 0; i < N; i++) {
            algoSpots[i] = br.readLine().toCharArray();
            for (int j = 0; j < algoSpots[i].length; j++) {
                if (!visited[algoSpots[i][j] - 'a']) {
                    visited[algoSpots[i][j] - 'a'] = true;
                    count++;
                }
            }
        }

        for (int i = 0; i < 26; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < algoSpots[i].length; j++) {
                if (j < algoSpots[i + 1].length) {
                    if (algoSpots[i][j] != algoSpots[i + 1][j]) {
                        graph[algoSpots[i][j] - 'a'].add(algoSpots[i + 1][j] - 'a');
                        degree[algoSpots[i + 1][j] - 'a']++;
                        break;
                    }
                } else {
                    System.out.print("!");
                    return;
                }
            }
        }

        for (int i = 0; i < 26; i++) {
            if (visited[i] && degree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) { // 위상정렬
            if (queue.size() >= 2) {
                System.out.print("?");
                return;
            }
            int now = queue.poll();
            sb.append((char) (now + 'a'));

            for (int next : graph[now]) {
                degree[next]--;
                if (degree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        System.out.print(sb.length() == count ? sb : "!");
    }
}