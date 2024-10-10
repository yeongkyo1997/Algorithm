import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int k;
    static int[] arr;

    static void dfs(int depth, int[] path, int start) throws IOException {
        if (depth == 6) {
            for (int p : path) {
                bw.write(p + " ");
            }
            bw.write("\n");
            return;
        }
        for (int i = start; i < k; i++) {
            path[depth] = arr[i];
            dfs(depth + 1, path, i + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        while (true) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if (k == 0)
                break;
            arr = new int[k];
            for (int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            dfs(0, new int[6], 0);
            bw.newLine();
        }
        bw.close();
    }
}