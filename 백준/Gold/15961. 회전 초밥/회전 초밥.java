import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N, D, K, C; // 접시의 수, 초밥의 가짓수, 연속해서 먹는 접시의 수, 쿠폰 번호
    static int[] arr; // 초밥의 종류
    static int[] check; // 초밥의 종류를 체크

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


        int cnt = 0; // 먹은 초밥의 가짓수
        int max; // 먹은 초밥의 가짓수의 최대값

        for (int i = 0; i < K; i++) { // 처음 K개의 초밥을 먹음
            if (check[arr[i]] == 0) cnt++; // 먹은 초밥의 가짓수를 체크
            check[arr[i]]++; // 먹은 초밥의 종류를 체크
        }

        if (check[C] == 0) max = cnt + 1; // 쿠폰 번호의 초밥을 먹지 않았을 경우
        else max = cnt; // 쿠폰 번호의 초밥을 먹었을 경우


        for (int i = 1; i < N; i++) {
            check[arr[i - 1]]--; // i번째 초밥을 먹기 전에 먹었던 초밥을 체크 해제
            if (check[arr[i - 1]] == 0) cnt--; // 먹은 초밥의 가짓수를 체크


            if (check[arr[(i + K - 1) % N]] == 0) cnt++; // i번째 초밥을 먹은 후에 먹은 초밥의 가짓수를 체크

            check[arr[(i + K - 1) % N]]++;  // i번째 초밥을 먹은 후에 먹은 초밥의 종류를 체크

            if (check[C] == 0) max = Math.max(max, cnt + 1); // 쿠폰 번호의 초밥을 먹지 않았을 경우
            else max = Math.max(max, cnt); // 쿠폰 번호의 초밥을 먹었을 경우

        }

        bw.write(max + "\n");
        bw.close();
    }
}