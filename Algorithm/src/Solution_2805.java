import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_2805 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    // sw 2805 농작물 수확하기
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] map = new int[N][N];
            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = str.charAt(j) - '0';
                }
            }
            int sum = 0;
            int mid = N / 2;
            for (int i = 0; i < N; i++) {
                if (i <= mid) {
                    for (int j = mid - i; j <= mid + i; j++) {
                        sum += map[i][j];
                    }
                } else {
                    for (int j = i - mid; j <= N - (i - mid) - 1; j++) {
                        sum += map[i][j];
                    }
                }
            }
            bw.write("#" + (t + 1) + " " + sum + "\n");
        }
        bw.flush();
        bw.close();
    }
}
