import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] list = new int[N];
        list[0] = Integer.parseInt(st.nextToken());

        for (int i = 1; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken()) + list[i - 1];
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            if (start == 0) {
                bw.write(list[end] + "\n");
                continue;
            }
            bw.write((list[end] - list[start - 1]) + "\n");
        }
        bw.flush();
        bw.close();
    }
}