import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static final int TREE_HEIGHT = 20;
    private static final int MAX_NUM = 100000;
    private static int node_num;
    private static int[] depth = new int[MAX_NUM];
    private static int[][] parent = new int[MAX_NUM + 1][TREE_HEIGHT];
    private static int[][] min_road = new int[MAX_NUM + 1][TREE_HEIGHT];
    private static int[][] max_road = new int[MAX_NUM + 1][TREE_HEIGHT];
    private static List<List<Pair>> adj = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        node_num = Integer.parseInt(br.readLine());

        for (int i = 0; i <= node_num; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < node_num - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int road = Integer.parseInt(st.nextToken());
            adj.get(a).add(new Pair(b, road));
            adj.get(b).add(new Pair(a, road));
        }

        for (int i = 0; i < min_road.length; i++) {
            for (int j = 0; j < min_road[i].length; j++) {
                min_road[i][j] = 1000001;
            }
        }

        findParent(0, 1, 0, 0);

        for (int k = 1; k < TREE_HEIGHT; k++) {
            for (int idx = 2; idx <= node_num; idx++) {
                if (parent[idx][k - 1] != 0) {
                    parent[idx][k] = parent[parent[idx][k - 1]][k - 1];
                    min_road[idx][k] = Math.min(min_road[parent[idx][k - 1]][k - 1], min_road[idx][k - 1]);
                    max_road[idx][k] = Math.max(max_road[parent[idx][k - 1]][k - 1], max_road[idx][k - 1]);
                }
            }
        }

        int pair_num = Integer.parseInt(br.readLine());
        while (pair_num-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            Pair result = findMinMaxRoad(a, b);
            System.out.println(result.first + " " + result.second);
        }
    }

    private static void findParent(int par, int now, int dep, int road_len) {
        depth[now] = dep;
        parent[now][0] = par;
        min_road[now][0] = max_road[now][0] = road_len;

        for (Pair p : adj.get(now)) {
            if (p.first != par) {
                findParent(now, p.first, dep + 1, p.second);
            }
        }
    }

    private static Pair findMinMaxRoad(int a, int b) {
        int min_result = 1000001;
        int max_result = 0;

        if (depth[a] != depth[b]) {
            if (depth[a] < depth[b]) {
                int temp = a;
                a = b;
                b = temp;
            }

            int dif = depth[a] - depth[b];
            for (int i = 0; dif > 0; i++) {
                if (dif % 2 == 1) {
                    min_result = Math.min(min_result, min_road[a][i]);
                    max_result = Math.max(max_result, max_road[a][i]);
                    a = parent[a][i];
                }
                dif = dif >> 1;
            }
        }

        if (a != b) {
            for (int k = TREE_HEIGHT - 1; k >= 0; k--) {
                if (parent[a][k] != 0 && parent[a][k] != parent[b][k]) {
                    min_result = Math.min(min_result, min_road[a][k]);
                    min_result = Math.min(min_result, min_road[b][k]);

                    max_result = Math.max(max_result, max_road[a][k]);
                    max_result = Math.max(max_result, max_road[b][k]);
                    a = parent[a][k];
                    b = parent[b][k];
                }
            }

            min_result = Math.min(min_result, min_road[a][0]);
            min_result = Math.min(min_result, min_road[b][0]);

            max_result = Math.max(max_result, max_road[a][0]);
            max_result = Math.max(max_result, max_road[b][0]);
        }

        return new Pair(min_result, max_result);
    }

    public static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}