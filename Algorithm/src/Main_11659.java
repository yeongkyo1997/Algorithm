import java.io.*;
import java.util.StringTokenizer;

import static java.util.stream.IntStream.rangeClosed;

public class Main_11659 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n, m;
        int[] list;

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new int[n + 1];
        st = new StringTokenizer(br.readLine());

        list[1] = Integer.parseInt(st.nextToken());

        rangeClosed(2, n).forEach(i -> list[i] = list[i - 1] + Integer.parseInt(st.nextToken()));

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int result = list[end] - list[start - 1];
            bw.write(result + "\n");
        }
        bw.flush();
        bw.close();
    }

}
