import java.io.*;
import java.util.StringTokenizer;

public class Main_2531_회전_초밥 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N, d, k, c; // 접시 수, 초밥 가짓수, 연속해서 먹는 접시 수, 쿠폰 번호
    static int flag; // 같은 종류의 초밥이 있는지 체크
    static int coupon; // 쿠폰 번호와 같은 초밥이 있는지 체크
    static int result = 0; // 최대값
    static int sushi[]; // 초밥
    static int check[]; // 초밥 종류 체크
    static int eat[]; // 먹은 초밥

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        sushi = new int[N];
        check = new int[d + 1];
        eat = new int[N];

        for (int i = 0; i < N; i++)
            sushi[i] = Integer.parseInt(br.readLine());


        for (int i = 0; i < N; i++) {
            flag = 0; // flag 초기화
            coupon = 1; // coupon 초기화
            for (int j = i; j < i + k; j++) { // k개의 초밥 먹기
                if (check[sushi[j % N]] == 1) flag++; // 같은 종류의 초밥이 있으면 flag++
                else check[sushi[j % N]] = 1; // 같은 종류의 초밥이 없으면 check

                if (sushi[j % N] == c) coupon = 0; // 쿠폰 번호와 같은 초밥이 있으면 coupon = 0
            }

            result = Math.max(result, k - flag + coupon); // 최대값 구하기, flag가 0이면 같은 종류의 초밥이 없다는 뜻
            check = new int[d + 1]; // check 초기화
        }

        bw.write(String.valueOf(result));
        bw.close();
    }
}
