import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int E, S, M;
        st = new StringTokenizer(br.readLine());
        E = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int e = 1, s = 1, m = 1;

        for (int i = 1; i <= 7980; i++) {
            if (e == E && s == S && m == M) {
                bw.write(i + "");
                break;
            }
            e++;
            s++;
            m++;
            if (e == 16) e = 1;
            if (s == 29) s = 1;
            if (m == 20) m = 1;
        }

        bw.close();
    }
}