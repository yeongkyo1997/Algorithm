import java.io.*;
import java.util.StringTokenizer;

public class Main_1093_스티커_수집 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int n, k;
    static int[] price, value;
    static int[] lprice, lvalue, rprice, rvalue;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        price = new int[n];
        value = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) price[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) value[i] = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());
        int sum = 0;
        int cnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < cnt; i++) sum += price[Integer.parseInt(br.readLine())];

        lprice = new int[n / 2];
        lvalue = new int[n / 2];
        rprice = new int[n - n / 2];
        rvalue = new int[n - n / 2];

        for (int i = 0; i < n / 2; i++) {
            lprice[i] = price[i];
            lvalue[i] = value[i];
        }
        for (int i = 0; i < n - n / 2; i++) {
            rprice[i] = price[i + n / 2];
            rvalue[i] = value[i + n / 2];
        }

        int ans = 1 << 30;
        for (int i = 0; i < (1 << n / 2); i++) {
            int lsum = 0, lval = 0;
            for (int j = 0; j < n / 2; j++) {
                if ((i & (1 << j)) != 0) {
                    lsum += lprice[j];
                    lval += lvalue[j];
                }
            }
            if (lsum > k) continue;
            for (int j = 0; j < (1 << (n - n / 2)); j++) {
                int rsum = 0, rval = 0;
                for (int l = 0; l < n - n / 2; l++) {
                    if ((j & (1 << l)) != 0) {
                        rsum += rprice[l];
                        rval += rvalue[l];
                    }
                }
                if (rsum > k - lsum) continue;
                ans = Math.min(ans, lsum + rsum - sum);
            }
        }
        if (ans == 1 << 30) System.out.println(-1);
        else System.out.println(ans);
    }
}