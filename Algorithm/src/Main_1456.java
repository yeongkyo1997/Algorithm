import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1456 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static boolean[] prime = new boolean[10000001];

    static {
        for (int i = 2; i * i < prime.length; i++) {
            if (i < 2) {
                prime[i] = true;
            } else {
                if (!prime[i]) for (int j = i * i; j < prime.length; j += i) {
                    prime[j] = true;
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        int cnt = 0;
        long num = A;
        while (true) {
            if (num * num > B) break;
            for (int i = 2; i < 100; i++) {
                if (i * i > B) break;
            }
            if (!prime[(int) num++]) cnt++;
        }
        bw.write(cnt + "\n");
        bw.close();
    }
}
