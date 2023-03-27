import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2437_저울 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N;
    static int[] a;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        a = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);

        int target = 1;
        for (int i = 0; i < N; i++) {
            if (target < a[i]) break;
            target += a[i];
        }

        bw.write(target + "\n");
        bw.close();
    }
}