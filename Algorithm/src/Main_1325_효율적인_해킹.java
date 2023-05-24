import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_1325_효율적인_해킹 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int n, m;
    static int cnt = 0;

    static ArrayList<Integer>[] arr;
    static ArrayList<Integer> result;
    static int max = -1;
    static int[] visited;

    static void dfs(int node) {

        visited[node] = 1;
        cnt++;

        for (int i = 0; i < arr[node].size(); i++) {

            if (visited[arr[node].get(i)] == 0) {
                dfs(arr[node].get(i));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[b].add(a);
        }

        for (int i = 1; i <= n; i++) {
            cnt = 0;
            visited = new int[n + 1];
            dfs(i);

            if (max < cnt) {
                result = new ArrayList<>();
                max = cnt;
                result.add(i);
            } else if (max == cnt) {
                result.add(i);
            }
        }

        Collections.sort(result);

        for (Integer integer : result) {
            bw.write(integer + " ");
        }

        bw.close();
    }
}