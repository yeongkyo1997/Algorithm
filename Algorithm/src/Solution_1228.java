import java.io.*;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Solution_1228 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        for (int t = 1; t < 11; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] list = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) list[i] = Integer.parseInt(st.nextToken());

            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                st.nextToken();
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int[] tmp = IntStream.range(0, y).map(j -> Integer.parseInt(st.nextToken())).toArray();

                int[] newList = new int[N + y];
                if (x >= 0) System.arraycopy(list, 0, newList, 0, x);
                System.arraycopy(tmp, 0, newList, x, y);

                if (N - x >= 0) System.arraycopy(list, x, newList, x + y, N - x);
                list = newList;
                N += y;
            }

            bw.write("#" + t + " ");
            for (int i = 0; i < 10; i++) bw.write(list[i] + " ");

            bw.write("\n");
        }
        bw.close();
    }
}
