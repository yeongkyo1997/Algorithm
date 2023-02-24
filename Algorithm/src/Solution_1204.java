import java.io.*;
import java.util.StringTokenizer;

public class Solution_1204 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int tc = Integer.parseInt(br.readLine());
            bw.write(String.format("#%d ", tc));

            int[] list = new int[101];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 1000; i++) {
                list[Integer.parseInt(st.nextToken())]++;
            }

            int result = 0;
            int cnt = 0;

            for (int i = 0; i < 101; i++) {
                if (cnt <= list[i]) {
                    cnt = list[i];
                    result = Math.max(i, result);
                }
            }
            bw.write(result + "\n");
        }
        bw.close();
    }
}
