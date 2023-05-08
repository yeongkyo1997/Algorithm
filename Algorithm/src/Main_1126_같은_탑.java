import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main_1126_같은_탑 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int n;
    static int h;
    static int[][] s = new int[2][250001];
    static int val;
    static int i;

    public static void main (String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        IntStream.rangeClosed(0, 250000).forEach(j -> s[0][j] = -1);
        s[0][0] = 0;

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            int ni = i ^ 1;
            for (int j = 0; j <= 250000; ++j) {
                if ((val = s[i][j]) >= 0) {
                    int a = j + h, b = Math.abs(j - h);
                    s[ni][j] = Math.max(s[ni][j], val);
                    s[ni][j] = Math.max(s[ni][j], val);
                    if (a <= 250000) s[ni][a] = Math.max(s[ni][a], val + h);
                    if (b <= 250000) s[ni][b] = Math.max(s[ni][b], val + (j < h ? b : 0));
                }
            }
            i = ni;
        }

        bw.write(String.valueOf(s[i][0] > 0 ? s[i][0] : -1));
        bw.close();
    }
}
