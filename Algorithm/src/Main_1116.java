import java.io.*;
import java.util.StringTokenizer;

// BOJ 1116 - 순열
public class Main_1116 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static int[] arr;
    static int[] result;
    static boolean[] visited;
    static int count = 0;


    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        result = new int[N];
        visited = new boolean[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        permutation(0);
        bw.write(count + "\n");
        bw.close();
    }

    static void permutation(int depth) {
        if (depth == N) {
            boolean isPossible = true;
            for (int i = 0; i < N; i++) {
                if (arr[i] != 0 && arr[i] != Math.abs(result[i] - result[(i + 1) % N])) {
                    isPossible = false;
                    break;
                }
            }
            if (isPossible) count++;
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = i;
                permutation(depth + 1);
                visited[i] = false;
            }
        }
    }
}
