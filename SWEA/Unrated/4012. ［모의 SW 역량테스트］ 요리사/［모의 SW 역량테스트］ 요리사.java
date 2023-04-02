import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 비트마스킹을 이용한 조합
public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N;  // 재료의 수
    static int[][] arr; // 재료의 시너지 정보
    static int min; // 최소 맛 차이

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            min = 10000000;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            solve(0, 0, 0);
            bw.write("#" + t + " " + min + "\n");
        }
        bw.flush();
        bw.close();
    }

    /*
     * 맛 차이의 절댓값을 구하는 함수
     * a: 고른 재료
     * b: 고르지 않은 재료
     */
    static void taste(int a, int b) {
        int result = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if ((a & (1 << i)) != 0 && (a & (1 << j)) != 0) { // 고른 걸 더해주고
                    result += arr[i][j];
                } else if ((b & (1 << i)) != 0 && (b & (1 << j)) != 0) { // 안 고른 걸 빼준다.
                    result -= arr[i][j];
                }
            }
        }
        min = Math.min(min, Math.abs(result));
    }

    /*
     * cur: 현재 재료의 번호
     * a: 고른 재료
     * b: 고르지 않은 재료
     */
    static void solve(int cur, int a, int b) {
        if (cur == N) { // 모든 재료를 고른 경우
            taste(a, b);
            return;
        }
        solve(cur + 1, a | (1 << cur), b); // 선택하는 경우
        solve(cur + 1, a, b | (1 << cur)); // 선택하지 않는 경우
    }
}