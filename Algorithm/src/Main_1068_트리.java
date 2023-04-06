import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main_1068_트리 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N, K, cnt;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());

        IntStream.range(0, N).forEach(i -> arr[i] = Integer.parseInt(st.nextToken()));

        K = Integer.parseInt(br.readLine());
        dfs(K);
        cnt = 0;

        for (int i = 0; i < N; i++) {
            if (arr[i] != -2 && i != arr[i]) {
                cnt++;
            }
        }
        bw.write(String.valueOf(cnt));
        bw.close();
    }

    static void dfs(int num) {
        arr[num] = -2;
        for (int i = 0; i < N; i++) {
            if (num == arr[i]) {
                dfs(i);
            }
        }
    }
}