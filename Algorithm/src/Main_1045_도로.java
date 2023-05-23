import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main_1045_도로 {
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));

        parents = new int[n];
        IntStream.range(0, n).forEach(i -> parents[i] = i);

        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = i + 1; j < n; j++) if (row.charAt(j) == 'Y') pq.offer(new int[]{i, j});
        }

        if (pq.size() < m) {
            System.out.println(-1);
        } else {
            int[] result = new int[n];
            int edgeNum = 0;
            PriorityQueue<int[]> pq2 = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));

            while (!pq.isEmpty()) {
                int[] nodes = pq.poll();
                int node1 = nodes[0];
                int node2 = nodes[1];

                if (union(node1, node2)) {
                    result[node1]++;
                    result[node2]++;
                    edgeNum++;
                } else {
                    pq2.offer(new int[]{node1, node2});
                }
            }

            if (edgeNum != n - 1) {
                System.out.println(-1);
            } else {
                IntStream.range(0, m - edgeNum).mapToObj(i -> pq2.poll()).forEach(nodes -> {
                    int node1 = nodes[0];
                    int node2 = nodes[1];
                    result[node1]++;
                    result[node2]++;
                });
                Arrays.stream(result).mapToObj(ans -> ans + " ").forEach(System.out::print);
            }
        }
    }

    private static int find(int node) {
        if (parents[node] == node) {
            return node;
        } else {
            parents[node] = find(parents[node]);
            return parents[node];
        }
    }

    private static boolean union(int node1, int node2) {
        int root1 = find(node1);
        int root2 = find(node2);

        if (root1 == root2) {
            return false;
        } else {
            parents[root2] = root1;
            return true;
        }
    }
}
