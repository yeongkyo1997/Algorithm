import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int n, m;
    static int[] arr;
    static int[] num;

    static void seq(int x, int len) throws IOException {
        if (len == m) {
            for (int i = 0; i < m; i++)
                bw.write(arr[i] + " ");
            bw.write("\n");
            return;
        }

        int last = 0;

        for (int i = x; i < n; i++) {
            if (num[i] != last) {
                arr[len] = num[i];
                last = arr[len];
                seq(i, len + 1);
            }
        }
    }


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        num = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            num[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(num);

        seq(0, 0);

        bw.flush();
        bw.close();
        br.close();
    }
}