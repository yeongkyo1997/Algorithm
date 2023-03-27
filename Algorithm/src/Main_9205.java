import java.io.*;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main_9205 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws NumberFormatException, IOException {
        int t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n + 2][2];

            for (int i = 0; i < n + 2; i++) {
                st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }

            boolean[] visited = new boolean[n + 2];
            visited[0] = true;

            dfs(arr, visited, 0, 20 * 50);
            bw.write(visited[n + 1] ? "happy\n" : "sad\n");
        }
        bw.flush();
        bw.close();
    }

    static void dfs(int[][] arr, boolean[] visited, int index, int distance) {
        if (distance < 0) {
            return;
        }
        IntStream.range(0, arr.length).filter(i -> !visited[i]).forEach(i -> {
            int dist = Math.abs(arr[index][0] - arr[i][0]) + Math.abs(arr[index][1] - arr[i][1]);
            if (dist <= 1000) {
                visited[i] = true;
                dfs(arr, visited, i, distance - dist);
            }
        });
    }

}