import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N, d, k, c;
    static int flag;
    static int coupon;
    static int result = 0;
    static int sushi[];
    static int check[];
    static int eat[];

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
            flag = 0;
            coupon = 1;
            for (int j = i; j < i + k; j++) {
                if (check[sushi[j % N]] == 1) flag++;
                else check[sushi[j % N]] = 1;

                if (sushi[j % N] == c) coupon = 0;
            }

            result = Math.max(result, k - flag + coupon);
            check = new int[d + 1];
        }

        bw.write(String.valueOf(result));
        bw.close();
    }
}