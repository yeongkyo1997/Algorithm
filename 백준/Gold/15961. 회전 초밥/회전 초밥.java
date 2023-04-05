import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N, D, K, C;
    static int[] arr;
    static int[] check;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new int[N];
        check = new int[D + 1];

        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(br.readLine());


        int cnt = 0;
        int max;
        for (int i = 0; i < K; i++) {
            if (check[arr[i]] == 0) cnt++;
            check[arr[i]]++;
        }

        if (check[C] == 0) max = cnt + 1;
        else max = cnt;


        for (int i = 1; i < N; i++) {
            check[arr[i - 1]]--;
            if (check[arr[i - 1]] == 0) cnt--;


            if (check[arr[(i + K - 1) % N]] == 0) {
                cnt++;
            }
            check[arr[(i + K - 1) % N]]++;

            if (check[C] == 0) max = Math.max(max, cnt + 1);
            else max = Math.max(max, cnt);

        }

        bw.write(max + "\n");
        bw.close();
    }
}