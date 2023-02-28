import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int cnt = 0;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int L, P, V;
            L = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());

            int result = 0;

            if (L != 0 && P != 0 && V != 0) {
                result += (V / P) * L;
                result += Math.min(V % P, L);
                bw.write("Case " + ++cnt + ": " + result + "\n");
            }

            if (L == 0 && P == 0 && V == 0) break;
        }
        bw.close();
    }
}