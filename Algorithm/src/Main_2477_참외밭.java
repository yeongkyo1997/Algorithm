import java.io.*;
import java.util.StringTokenizer;

public class Main_2477_참외밭 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int K;
    static int[] A = new int[6 + 10];
    static int[] B = new int[6 + 10];
    static int[][] dir = {{1, 3}, {4, 1}, {2, 4}, {3, 2}};

    static int solve() {
        for (int i = 0; i < 6; i++) {
            A[6 + i] = A[i];
            B[6 + i] = B[i];
        }

        int small;
        int big;

        for (int i = 2; i < 9; i++) {
            for (int j = 0; j < 4; j++) {
                if (A[i] == dir[j][0] && A[i + 1] == dir[j][1]) {
                    small = B[i] * B[i + 1];
                    big = B[i - 2] * B[i + 3];
                    return K * (big - small);
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        int result;
        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
        }

        result = solve();

        bw.write(result + "\n");
        bw.close();
    }
}
