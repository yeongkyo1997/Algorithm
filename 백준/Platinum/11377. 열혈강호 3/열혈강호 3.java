import java.io.*;
import java.util.*;

public class Main {

    static List<Integer>[] v = new ArrayList[1010];
    static int[] work = new int[1010];
    static boolean[] visit = new boolean[1010];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; ++i) {
            v[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            for (int j = 0; j < c; ++j) {
                int num = Integer.parseInt(st.nextToken());
                v[i].add(num);
            }
        }

        Arrays.fill(work, 0);
        int count = 0;
        for (int i = 1; i <= n; ++i) {
            Arrays.fill(visit, false);
            if (DFS(i)) {
                ++count;
            }
        }

        for (int i = 1; i <= n; ++i) {
            Arrays.fill(visit, false);
            if (DFS(i)) {
                ++count;
                --k;
                if (k == 0) {
                    break;
                }
            }
        }

        System.out.println(count);
    }

    public static boolean DFS(int x) {
        for (int i = 0; i < v[x].size(); ++i) {
            int t = v[x].get(i);

            if (visit[t]) {
                continue;
            }
            visit[t] = true;

            if (work[t] == 0 || DFS(work[t])) {
                work[t] = x;
                return true;
            }
        }
        return false;
    }
}
