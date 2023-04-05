import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_15961_회전_초밥 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N, D, K, C; // 접시의 수, 초밥의 가짓수, 연속해서 먹는 접시의 수, 쿠폰 번호
    static int[] arr; // 초밥의 종류
    static int[] check; // 초밥의 종류를 체크

    public static void main(String[] args) throws Exception {
        int result = 0;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new int[N];
        check = new int[D + 1];

        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            check[arr[i]] += 1;
        }

        int left = 0;
        int right = K;

        
    }
}