import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_2961 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[][] list = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            list[i] = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
        }
        int result = Integer.MAX_VALUE;

        for (int i = 1; i < (1 << N); i++) {
            int S = 1;
            int B = 0;
            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) == 0)
                    continue;
                S *= list[j][0];
                B += list[j][1];
            }
            result = Math.min(Math.abs(S - B), result);
        }
        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }
}
