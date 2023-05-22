import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int n, m;
    static ArrayList<Integer>[] v;
    static boolean[] visited;
    static int[] work;
    static int ret = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        v = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            v[i] = new ArrayList<>();
        }

        visited = new boolean[n + 1];
        work = new int[m + 1];

        for (int i = 1; i <= n; i++) {
            int m = sc.nextInt();
            for (int j = 0; j < m; j++) {
                int can = sc.nextInt();
                v[i].add(can);
            }
        }

        for (int i = 1; i <= n; i++) {
            Arrays.fill(visited, false);
            if (dfs(i))
                ret++;
        }

        System.out.println(ret);
        sc.close();
    }

    public static boolean dfs(int from) {
        visited[from] = true;

        int len = v[from].size();
        for (int i = 0; i < len; i++) {
            int to = v[from].get(i);
            if (work[to] == 0 || !visited[work[to]] && dfs(work[to])) {
                work[to] = from;
                return true;
            }
        }

        return false;
    }
}