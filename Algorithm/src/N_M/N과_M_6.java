package N_M;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과_M_6 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static boolean[] visited;
    static int[] list;
    static int[] result;
    static int N, M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new int[N];
        result = new int[M];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(list);
        sol(0, 0);
        bw.flush();
        bw.close();
    }

    static void sol(int depth, int start) throws IOException {
        if (depth == M) {
            for (int i : result) {
                bw.write(i + " ");
            }
            bw.write("\n");
            return;
        }
        for (int i = start; i < list.length; i++) {
            if (!visited[i]) {
                result[depth] = list[i];
                visited[i] = true;
                sol(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }
}
