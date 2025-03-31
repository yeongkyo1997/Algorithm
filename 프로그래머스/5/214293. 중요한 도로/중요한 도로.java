import java.util.*;

public class Solution {

    static class Node implements Comparable<Node> {
        int n;
        long cost;

        Node(int n, long cost) {
            this.n = n;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.cost, o.cost);
        }
    }

    static int N,
            M;

    static ArrayList<Node>[] graph;

    static ArrayList<Integer>[] path;
    static long[] answer1;
    static long[] answer2;
    static long minCost;

    static HashMap<Integer, Integer>[] roadNum;

    static int[] result;

    static HashSet<Integer>[] pathCnt;
    static int[] visited;

    static void dijkstra1() {

        for (int i = 1; i <= N; i++) {
            answer1[i] = 999999987654321L;
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));
        answer1[1] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (answer1[now.n] < now.cost)
                continue;
            for (int i = 0; i < graph[now.n].size(); i++) {
                Node nxt = graph[now.n].get(i);
                long nextCost = answer1[now.n] + nxt.cost;
                if (nextCost > answer1[nxt.n])
                    continue;
                else if (nextCost == answer1[nxt.n]) {

                    path[nxt.n].add(now.n);
                } else {

                    path[nxt.n].clear();
                    path[nxt.n].add(now.n);
                    answer1[nxt.n] = nextCost;
                    pq.offer(new Node(nxt.n, nextCost));
                }
            }
        }
        minCost = answer1[N];
    }

    static void dijkstra2() {
        for (int i = 1; i <= N; i++) {
            answer2[i] = 999999987654321L;
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(N, 0));
        answer2[N] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (answer2[now.n] < now.cost)
                continue;
            for (int i = 0; i < graph[now.n].size(); i++) {
                Node nxt = graph[now.n].get(i);
                long nextCost = answer2[now.n] + nxt.cost;
                if (nextCost >= answer2[nxt.n])
                    continue;
                answer2[nxt.n] = nextCost;
                pq.offer(new Node(nxt.n, nextCost));
            }
        }
    }

    static void printSummary() {
        System.out.println(minCost);
        for (int i = N; i != 1; i = path[i].get(0)) {
            for (int j : path[i]) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static List<Integer> solution(int n, int[][] roads) {
        N = n;
        M = roads.length;

        graph = new ArrayList[N + 1];
        path = new ArrayList[N + 1];
        answer1 = new long[N + 1];
        answer2 = new long[N + 1];
        roadNum = new HashMap[N + 1];
        pathCnt = new HashSet[N + 1];
        visited = new int[N + 1];
        result = new int[M + 1];

        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
            path[i] = new ArrayList<>();
            roadNum[i] = new HashMap<>();
            pathCnt[i] = new HashSet<>();
        }

        for (int i = 1; i <= M; i++) {
            int a = roads[i - 1][0];
            int b = roads[i - 1][1];
            long l = roads[i - 1][2];
            long t = roads[i - 1][3];

            graph[a].add(new Node(b, l + t));
            graph[b].add(new Node(a, l + t));
            roadNum[a].put(b, i);
            roadNum[b].put(a, i);
        }

        dijkstra1();
        dijkstra2();

        for (int i = 1; i <= M; i++) {
            int a = roads[i - 1][0];
            int b = roads[i - 1][1];
            long l = roads[i - 1][2];
            long t = roads[i - 1][3];
            if (t == 0)
                continue;
            if ((answer1[a] + answer2[b] + l < minCost) || (answer1[b] + answer2[a] + l < minCost)) {
                int roadId = roadNum[a].get(b);
                result[roadId] = 1;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(N);
        visited[N] = 1;
        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                int now = q.poll();

                for (int k = 0; k < path[now].size(); k++) {
                    int nxt = path[now].get(k);

                    if (path[now].size() == 1 && qSize == 1)
                        pathCnt[nxt].add(now);
                    if (visited[nxt] != 0)
                        continue;
                    visited[nxt] = 1;
                    q.offer(nxt);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j : pathCnt[i]) {
                int roadId = roadNum[i].get(j);
                result[roadId] = 1;
            }
        }

        List<Integer> answer = new ArrayList<>();

        for (int i = 1; i <= M; i++) {
            if (result[i] == 1)
                answer.add(i);
        }
        if (answer.size() == 0)
            answer.add(-1);
        return answer;
    }

}
