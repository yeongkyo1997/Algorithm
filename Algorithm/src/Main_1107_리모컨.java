import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_1107_리모컨 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N;
    static int M;
    static int result;
    static int[] broken;
    static int[] visited;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        broken = new int[10];
        visited = new int[1000001];
        if (M > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                broken[Integer.parseInt(st.nextToken())] = 1;
            }
        }
        result = Math.abs(N - 100);
        for (int i = 0; i < 1000001; i++) {
            int length = check(i);
            if (length > 0) {
                int k = Math.abs(N - i);
                if (k + length < result) {
                    result = k + length;
                }
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    static int check(int k) {
        int length = 0;
        if (k == 0) {
            return broken[0] == 1 ? 0 : 1;
        }
        while (k > 0) {
            length++;
            if (broken[k % 10] == 1) {
                return 0;
            }
            k /= 10;
        }
        return length;
    }
}


